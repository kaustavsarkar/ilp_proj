package com.tcs.ilp.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.Const;

import com.tcs.ilp.POJO.Cart;
import com.tcs.ilp.POJO.Items;
import com.tcs.ilp.POJO.Order;
import com.tcs.ilp.POJO.Outlet;
import com.tcs.ilp.POJO.User;
import com.tcs.ilp.Services.AdminServices;
import com.tcs.ilp.Services.CustomerService;
import com.tcs.ilp.Services.ItemService;
import com.tcs.ilp.Util.Constants;
import com.tcs.ilp.Util.GeneralMethods;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String json = null;
        CustomerService customerservice = new CustomerService();
        System.out.println("going for json for oulet selectiojn");
        ArrayList<String> cities = new ArrayList<String>();
        ArrayList<Outlet> outlets = new ArrayList<Outlet>();
        String state = request.getParameter("stateName");

        if (state != null) {
            System.out.println(state);
            cities = customerservice.viewOutletStates(state);
            System.out.println("in to before result");

            for (String city : cities) {
                System.out.println(city + "::");
            }

            json = new Gson().toJson(cities);
            response.setContentType("application/json");
            response.getWriter().write(json);
        }
        String city1 = request.getParameter("cityName");
        System.out.println(city1);
        if (city1 != null) {
            System.out.println("into city..........................");
            outlets = customerservice.viewOutletStatesDistinct(city1);
            Gson gson = new Gson();
            JsonElement element = gson.toJsonTree(outlets,
                    new TypeToken<List<Outlet>>() {
                    }.getType());
            System.out.println("into city...........part222222...............");
            JsonArray jsonArray = element.getAsJsonArray();
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);
            System.out.println("into city............finallllll..............");

        }

        System.out.println("into get");
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // System.out.println(request.getParameter("name"));
        HttpSession session = request.getSession(false);
        int customerId = 0;
        ArrayList<Items> items = new ArrayList<Items>();
        System.out.println("into dopost");
        String action = request.getParameter("action");
        System.out.println(action);
        CustomerService customerservice = new CustomerService();
        User customer = new User();
        // ItemService itemservice=new ItemService();
        System.out.println(session);

        if ("getitems".equals(action)) {

            String name = request.getParameter("name");
            System.out.println(name);
            CustomerService customerService = new CustomerService();
            items = customerService.getItemsFromDepartment(name);
            System.out.println("123456789");
            request.setAttribute("items", items);

            GeneralMethods.RequestForward(request, response, Constants.ITEMS_IN_DEPARTMENT_PAGE);
        } else if ("cartselection".equals(action)) {
            System.out.println("hii");
            String[] cart = request.getParameterValues("items");
            if (request.getSession(false).getAttribute("name") != null) {
                System.out.println("session exists");
                customerId = Integer.parseInt(request.getParameter("id")
                        .toString());
                System.out.println(customerId);
            }
            try {
                for (int i = 0; i < cart.length; i++) {
                    customerservice.addCartItem(customerservice.retreiveItem(
                            Integer.parseInt(cart[i]), customerId));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (customerId != 0) {
                GeneralMethods.RequestForward(request, response, Constants.HOME_PAGE);
            } else {
                
                GeneralMethods.RequestForward(request, response, Constants.WELCOME_PAGE);
            }
        }

        else if ("CartViewer".equals(action)) {
            System.out.println("yeaaaaaaaaaaaaaaah");
            ArrayList<Items> itemCart = new ArrayList<Items>();
            customerId = Integer.parseInt(request.getParameter("customerId"));
            try {
                itemCart = customerservice.viewCart(customerId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("itemCart", itemCart);
            GeneralMethods.RequestForward(request, response, Constants.CART_VIEW_PAGE);
        } else if ("CartDeleteItems".equals(action)) {
            System.out.println("UIUIUIUIUI");
            int itemId = Integer.parseInt(request.getParameter("ItemsId"));
            try {
                customerservice.deleteCartItem(itemId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            GeneralMethods.RequestForward(request, response, Constants.CREATE_RESULT_PAGE);
        }

        else if ("Order".equalsIgnoreCase(action)) {
            ItemService itemService = new ItemService();

            ArrayList<Items> itemList = new ArrayList<Items>();
            System.out.println("Order button working");
            String[] itemId = request.getParameterValues("itemcart");
            System.out.println(itemId.length + "::" + itemId[0]);
            double[] quantity = new double[itemId.length];
            try {
                for (int i = 0; i < itemId.length; i++) {
                    String tot = "quantity" + itemId[i];
                    System.out.println(tot);
                    quantity[i] = Double.parseDouble((request
                            .getParameter("quantity" + itemId[i]).toString()));
                    System.out.println(quantity[i]);
                    System.out.println("helloooooo");
                    if (request.getSession().getAttribute("name") != null) {
                        customerId = Integer.parseInt(request.getSession(false)
                                .getAttribute("Id").toString());
                    }
                    itemList.add(itemService.searchitems(Integer
                            .parseInt(itemId[i])));
                    customerservice.updateCartQuantity(customerId, quantity[i],
                            Integer.parseInt(itemId[i]));

                }
                AdminServices adminservices = new AdminServices();
                ArrayList<Outlet> outlets = new ArrayList<Outlet>();
                outlets = adminservices.viewOutlet();
                request.setAttribute("outlets", outlets);
            } catch (Exception e) {
                System.out.println(e);
            }
            request.setAttribute("quantity", quantity);
            request.setAttribute("itemList", itemList);
            GeneralMethods.RequestForward(request, response, Constants.ORDER_PAGE);
        }

        if ("addOrder".equals(action)) {
            Order order = new Order();
            Cart cart = new Cart();
            double totalamount = 0;
            int orderId = -1;
            int index = 0;
            // TimeStamp
            int outletid = Integer.parseInt(request.getSession()
                    .getAttribute("outletid").toString());
            int custid = 0;
            if (request.getSession().getAttribute("Id") != null)
                custid = Integer.parseInt(request.getSession()
                        .getAttribute("Id").toString());
            Calendar calendar = Calendar.getInstance();
            java.util.Date now = calendar.getTime();
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(
                    now.getTime());

            System.out.println("hiiiii timeeee" + currentTimestamp);

            order.setCurrentTimestamp(currentTimestamp);
            ArrayList<Integer> itemid = (ArrayList<Integer>) request
                    .getSession().getAttribute("ItemId");
            ArrayList<Items> itemstot = new ArrayList<Items>();
            double[] itemcount = new double[itemid.size()];
            ArrayList<Double> amount = new ArrayList<Double>();
            int length = 0;
            for (int itemids : itemid) {
                Items item = new Items();
                item = customerservice.searchItems(itemids);
                cart = customerservice.retreiveItembyCart(itemids, custid);

                itemstot.add(item);
                amount.add(cart.getQuantity() * item.getPrice());
                totalamount = totalamount
                        + (cart.getQuantity() * item.getPrice());
                itemcount[length++] = item.getQuantity() - cart.getQuantity();
                order.setItemId(item.getItemId());
                order.setOutletId(outletid);

                System.out.println(cart.getQuantity() + "::"
                        + cart.getQuantity() * item.getPrice());

                order.setQuantity(cart.getQuantity());
                order.setCurrentTimestamp(currentTimestamp);
                order.setAmount(cart.getQuantity() * item.getPrice());
                order.setCustomerId(custid);

                System.out.println(order.getAmount() + "::"
                        + itemid.indexOf(itemids));

                index = itemid.indexOf(itemids);
                orderId = customerservice.addOrder(order,
                        itemid.indexOf(itemids));
            }

            request.setAttribute("orderId", orderId);
            ArrayList<Order> orders = new ArrayList<Order>();
            Outlet outlet = new Outlet();
            System.out.println("Entering into the confirmOrder ACTION");
            orderId = Integer.parseInt(request.getAttribute("orderId")
                    .toString());
            System.out.println(orderId + " This variable retreived");
            try {
                orders = customerservice.viewOrder(orderId);
                outlet = customerservice.searchOutlet(orders.get(0)
                        .getOutletId());
                int cartcount = customerservice.deleteCart(customerId);
                for (int itemids : itemid) {
                    cart = customerservice.retreiveItembyCart(itemids, custid);
                    customerservice.updateItemQuantity(itemids,
                            itemcount[itemid.indexOf(itemids)]);
                    customerservice.deleteCart(custid);
                }

            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
            request.getSession().setAttribute("outlet", outlet);
            request.setAttribute("orders", orders);
            request.setAttribute("outlet", outlet);
            GeneralMethods.RequestForward(request, response, Constants.VIEW_BILLING_PAGE);
        }

        else if ("setoutletid".equals(action)) {
            System.out.println("into setoutletid");
            String[] outletid = request.getParameterValues("radio");
            String[] itemid = request.getParameterValues("ItemId");
            System.out.println(itemid.length);
            ArrayList<Integer> itemids = new ArrayList<Integer>();
            for (int i = 0; i < outletid.length; i++) {
                request.getSession().setAttribute("outletid", outletid[i]);
            }
            for (int i = 0; i < itemid.length; i++) {
                itemids.add(Integer.parseInt(itemid[i]));
                System.out.println(itemids.get(i));
            }
            request.getSession().setAttribute("ItemId", itemids);
            ArrayList<Integer> ids = (ArrayList<Integer>) request.getSession()
                    .getAttribute("ItemId");
            System.out.println(ids.size());
            System.out.println(request.getSession().getAttribute("outletid")
                    .toString());

            GeneralMethods.RequestForward(request, response, Constants.PAYMENT_GATEWAY_PAGE);
        }

        // -------------------------delete guest cart--------------------------------//

        if ("DeleteGuestCart".equals(action)) {

            int custId = 0;
            customerservice.deleteCart(custId);
            GeneralMethods.RequestForward(request, response, Constants.WELCOME_PAGE);
        }

        // -----------------ADDING CUSTOMER-----------------------------//

        if ("addCustomer".equalsIgnoreCase(action)) {
            String date = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = (request.getParameter("date").toString());
            System.out.println(date);
            System.out.println("Inside add Customer");
            System.out.println(Long.parseLong(request.getParameter("zip")));
            customer.setName(request.getParameter("name"));
            customer.setPassword(request.getParameter("pass"));
            customer.setGender(request.getParameter("gender"));
            customer.setDob(date);
            customer.setEmail(request.getParameter("email"));
            customer.setAddress(request.getParameter("address"));
            customer.setCity(request.getParameter("city"));
            customer.setState(request.getParameter("state"));
            customer.setZipcode(Long.parseLong(request.getParameter("zip")
                    .toString()));
            customer.setPhone(Long.parseLong(request.getParameter("phone")));

            customerId = customerservice.createCustomer(customer);

            request.setAttribute("customerId", customerId);
            GeneralMethods.RequestForward(request, response, Constants.LOGIN_PAGE);
        }

        // -----------------------DEACTIVATE CUSTOMER---------------------------------//

        else if ("deactivate".equalsIgnoreCase(action)) {

            int id = Integer.parseInt(request.getParameter("id"));

            int count = customerservice.deleteCustomer(id);

            request.setAttribute("count", count);
            GeneralMethods.RequestForward(request, response, Constants.LOGIN_PAGE);
        } else if ("viewUrProfile".equals(action)) {
            System.out.println(request.getSession().getAttribute("Id"));
            customer = customerservice.viewUrProfile(Integer.parseInt(request
                    .getSession().getAttribute("Id").toString()));
            request.setAttribute("Profile", customer);
            System.out.println(customer.getDob());
            System.out.println(customer.getName());
            
            GeneralMethods.RequestForward(request, response, Constants.VIEW_YOUR_PROFILE_PAGE);
        }

        if ("updateform".equals(action)) {

            customer = customerservice.updateForm(Integer.parseInt(request
                    .getParameter("update")));
            // System.out.println(p.getProjectName());
            request.setAttribute("update", customer);
            request.setAttribute("count", request.getParameter("count"));

            GeneralMethods.RequestForward(request, response, Constants.UPDATE_FORM_PAGE);
        }

        if ("update".equals(action)) {

            PrintWriter out = response.getWriter();

            System.out.println("\n hello \n");
            customer.setUser_Id(Integer.parseInt(request.getParameter("userid")));
            // System.out.println(p3.getProjectId());
            customer.setPassword(request.getParameter("password"));
            customer.setName(request.getParameter("name"));
            String date = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(date);
            date = request.getParameter("dob").toString();
            customer.setDob(date);
            customer.setGender(request.getParameter("gender"));
            customer.setEmail(request.getParameter("email"));
            customer.setAddress(request.getParameter("address"));
            customer.setCity(request.getParameter("city"));
            customer.setState(request.getParameter("state"));
            customer.setZipcode(Integer.parseInt(request
                    .getParameter("zipcode")));
            customer.setPhone(Long.parseLong(request.getParameter("phone")));
            // NEEE TO CHECK THIS LINE
            customer.setCategory(request.getParameter("Category"));
            System.out.println("\n hello \n");
            System.out.println(request.getParameter("gender"));
            System.out.println(customer.getUser_Id());

            int count = customerservice.updateUrProfile(customer);
            System.out.println(count);
            if (count > 0) {
                out.println("<HTML><BODY><h3>successfully updated</h3><br><a href='JSP/Home.jsp'>Home</a></body></html>");
            } else {
                out.println("<html><body><h3>try once again...</h3></html></body>");
            }
        }

        if ("vieworders".equals(action)) {

            ArrayList<Order> orders = new ArrayList<Order>();
            ArrayList<Outlet> outlet = new ArrayList<Outlet>();
            System.out.println("ID ::"
                    + Integer.parseInt(request.getSession(false)
                            .getAttribute("Id").toString()));
            orders = customerservice.viewOrderbycustomer(Integer
                    .parseInt(request.getSession(false).getAttribute("Id")
                            .toString()));
            for (Order order : orders) {
                Outlet outlet1 = new Outlet();
                outlet1 = customerservice.searchOutlet(order.getOutletId());
                System.out.println("inside controller ::"
                        + outlet1.getOutletId());
                outlet.add(outlet1);
            }
            request.setAttribute("outlet", outlet);
            request.setAttribute("orders", orders);
            GeneralMethods.RequestForward(request, response, Constants.VIEW_ORDER_PAGE);
        }
    }
}