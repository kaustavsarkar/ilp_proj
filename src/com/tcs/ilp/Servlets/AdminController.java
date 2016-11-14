package com.tcs.ilp.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.Const;

import com.tcs.ilp.POJO.Department;
import com.tcs.ilp.POJO.Items;
import com.tcs.ilp.POJO.Outlet;
import com.tcs.ilp.POJO.User;
import com.tcs.ilp.Services.AdminServices;
import com.tcs.ilp.Services.ItemService;
import com.tcs.ilp.Services.LoginService;
import com.tcs.ilp.Util.Constants;
import com.tcs.ilp.Util.GeneralMethods;

/**
 * Servlet implementation class OrsController
 */
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // TODO Auto-generated method stub

        // ---------------- OBJECTS AND INSTANCES ---------------------------//

        Department department = new Department(); // Department Object
        Outlet outlet = new Outlet(); // Outlet Object
        AdminServices adminServices = new AdminServices(); // Object Of AdminServices() Class
        ArrayList<Outlet> outletList = null; // ArrayList for Outlets
        ArrayList<Department> departmentList = null; // ArrayList for Department

        // xx----------------- OBJECTS AND INSTANCES ---------------------------xx //

        String action = request.getParameter("action");

        // creating services.
        // AdminServices Adminservice=new AdminServices();
        LoginService loginservice = new LoginService();
        ItemService itemservice = new ItemService();
        PrintWriter out = response.getWriter();

        int updateCount = 0;
        int outletId = 0;
        int departmentId = 0;
        String ids = null;
        // servlet methods for performing admin operations

        // checking login credentials
        if ("login".equalsIgnoreCase(action)) {
            System.out
                    .println("Now the controller " + action + " is called \n");
            User user = new User();
            HttpSession session = request.getSession(true);
            System.out.println(request.getParameter("password"));
            if (session == null) {
                GeneralMethods.RequestForward(request, response,
                        Constants.LOGIN_PAGE);
                }

            user = loginservice.login(request.getParameter("username"),
                    request.getParameter("password"));
            session.setAttribute("name", user.getName());
            System.out.println(user.getUser_Id());
            session.setAttribute("Id", user.getUser_Id());
            request.setAttribute("user", user);
            String category = user.getCategory();
            if (category != null) {

                if (category.equalsIgnoreCase("ADMIN")) {
                    GeneralMethods.RequestForward(request, response,
                            Constants.ADMIN_PAGE);

                } else if (category.equalsIgnoreCase("CUSTOMER")) {
                    GeneralMethods.RequestForward(request, response,
                            Constants.HOME_PAGE);
                }
            } else {
                out.println("<html><body> <font color="
                        + "red"
                        + " >Sorry username and password did not match.</font></body></html>");
                System.out.println("UserId and Password incorrect !! ");

                GeneralMethods.RequestInclude(request, response,
                        Constants.LOGIN_PAGE);
            }

        } else if ("logout".equals(action)) {
            HttpSession session = request.getSession(false);
            /* session.invalidate(); */
            out.println("<Html><body>Logged out Successfully</body></html>");
            request.getSession().invalidate();

            response.sendRedirect(Constants.LOGIN_PAGE); // No logged-in user found,
                                                     // so redirect to login
                                                     // page.
            response.setHeader("Cache-Control",
                    "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
        }
        // add items
        else if ("additems".equalsIgnoreCase(action)) {

            System.out.println("\n hello \n");

            Items items = new Items();

            items.setItemId(0);
            items.setItemName(request.getParameter("itemname"));
            items.setDepartmentId(Integer.parseInt(request
                    .getParameter("departmentid")));
            items.setPrice(Double.parseDouble(request.getParameter("price")));
            items.setQuantity(Double.parseDouble(request
                    .getParameter("quantity")));

            /*
             * boolean
             * check=itemservice.addsearchitems(request.getParameter("itemname"
             * )); System.out.println(check); if(check==false){
             */
            int itemId = itemservice.additems(items);
            if (itemId > 0) {
                System.out.println("Item is added.Id=" + itemId);

                out.println("<html><body> Item is Added .\n Item Id is "
                        + itemId + "</body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_ITEM_PAGE);
            }
            else {

                System.out.println("Item  " + items.getItemName()
                        + " already present");

                out.println("<html><body> Item already present </body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_ITEM_PAGE);
            }
        }

        // view items

        else if ("viewitems".equalsIgnoreCase(action)) {
            ArrayList<Items> itemsList = itemservice.viewitems();

            request.setAttribute("itemsList", itemsList);

            GeneralMethods.RequestForward(request, response,
                    Constants.VIEW_ITEMS_PAGE);

        }
        // delete selected item
        else if ("deleteallitems".equalsIgnoreCase(action)) {

            System.out.println("inside delete");
            String[] itemId = request.getParameterValues("selectid");
            // String ids=null;
            // System.out.println(itemId.length);

            if (itemId != null) {
                ids = itemId[0];
                for (int i = 1; i <= itemId.length - 1; i++) {
                    // idList.add(Integer.parseInt(itemId[i]));
                    ids = ids + "," + itemId[i];
                    System.out.println("inside for loop");

                }

                updateCount = itemservice.deleteAllItems(ids);

                if (updateCount > 0) {

                    out.println("<html><body> Items deleted successfully !!</body></html>");
                    GeneralMethods.RequestInclude(request, response,
                            Constants.MANAGE_ITEM_PAGE);
                } else {
                    out.println("<html><body> Items  has not been deleted !! </body></html>");
                    GeneralMethods.RequestInclude(request, response,
                            Constants.MANAGE_ITEM_PAGE);
                }
            } else {
                out.println("<html><body> No items selected !!\nPlease select an Item.</body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_ITEM_PAGE);
            }
        }
        // search for a specific item
        else if ("searchitems".equalsIgnoreCase(action)) {

            String value = request.getParameter("value");
            if ("view".equalsIgnoreCase(value)) {
                System.out.println("\n value=view is called .. \n");
                System.out.println("ID "
                        + Integer.parseInt(request.getParameter("itemid"))
                        + " is viewed \n");
                Items items = itemservice.searchitems(Integer.parseInt(request
                        .getParameter("itemid")));

                request.setAttribute("items", items);

                GeneralMethods.RequestForward(request, response,
                        Constants.SEARCH_ITEM_RESULT_PAGE);
            } else if ("delete".equalsIgnoreCase(value)) {
                System.out.println("\n value=delete is called .. \n");

                System.out.println("ID "
                        + Integer.parseInt(request.getParameter("itemid"))
                        + " is viewed \n");
                Items items = itemservice.searchitems(Integer.parseInt(request
                        .getParameter("itemid")));

                request.setAttribute("items", items);

                GeneralMethods.RequestForward(request, response,
                        Constants.DELETE_ITEM_VIEW_PAGE);
            }
        }
        // update items
        else if ("updateitems".equalsIgnoreCase(action)) {
            System.out.println("\n updateitems is is called .. \n");
            Items items = new Items();
            System.out.println(request.getParameter("itemid"));
            items.setItemId(Integer.parseInt(request.getParameter("itemid")));
            items.setItemName(request.getParameter("itemname"));
            items.setDepartmentId(Integer.parseInt(request
                    .getParameter("departmentid")));
            items.setPrice(Double.parseDouble(request.getParameter("price")));
            items.setQuantity(Double.parseDouble(request
                    .getParameter("quantity")));

            updateCount = itemservice.updateitems(items);
            if (updateCount > 0) {
                out.println("<html><body> Item " + items.getItemName()
                        + " is updated successfully !!</body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_ITEM_PAGE);
            } else {
                out.println("<html><body> Item " + items.getItemName()
                        + " has not been updated !! </body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_ITEM_PAGE);
            }
        }
        // delete items
        else if ("deleteitems".equalsIgnoreCase(action)) {
            System.out.println("\n delete items is is called .. \n");

            updateCount = itemservice.deleteitems(Integer.parseInt(request
                    .getParameter("itemid")));
            if (updateCount > 0) {

                out.println("<html><body> Item "
                        + Integer.parseInt(request.getParameter("itemid"))
                        + " is deleted successfully !!</body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_ITEM_PAGE);
                } else {
                out.println("<html><body> Item "
                        + Integer.parseInt(request.getParameter("itemid"))
                        + " has not been deleted !! </body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_ITEM_PAGE);
                }
        }
        // view all customers
        else if ("viewcustomersdetail".equalsIgnoreCase(action)) {
            System.out.println("into view customers detail \n");

            ArrayList<User> UserList = new ArrayList<User>();

            UserList = adminServices.viewallDetails();
            request.setAttribute("allcustomers", UserList);

            GeneralMethods.RequestForward(request, response,
                    Constants.VIEW_CUSTOMER_DETAILS_PAGE);
        }
        // search customer
        else if ("searchcustomer".equalsIgnoreCase(action)) {
            System.out.println("into Search customer");
            User user = adminServices.confirmdelete(Integer.parseInt(request
                    .getParameter("id").toString()));

            request.setAttribute("user", user);
            GeneralMethods.RequestForward(request, response,
                    Constants.VIEW_CUSTOMER_DELETE_PAGE);
        }
        // delete customers
        else if ("Confirm Delete".equalsIgnoreCase(action)) {

            System.out.println("into delete \n");
            int id = Integer.parseInt(request.getParameter("Id"));
            System.out.println(id);

            updateCount = adminServices.deleteCustomer(id);

            if (updateCount > 0) {

                out.println("<html><body> Customer " + id
                        + " is deleted successfully !!</body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_CUSTOMER_PAGE);
            } else {
                out.println("<html><body> Customer " + id
                        + " has not been deleted !! </body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_CUSTOMER_PAGE);
            }
        }
        // --------------------------------OUTLET MANAGEMENT---------------------------------------- //

        // -------------------------- Adding Outlets ----------------------------------- //

        else if ("addoutlet".equalsIgnoreCase(action)) {

            outlet.setAddress(request.getParameter("address"));
            outlet.setCity(request.getParameter("city"));
            outlet.setState(request.getParameter("state"));
            outlet.setZipCode(Long.parseLong(request.getParameter("zipcode")));

            outletId = adminServices.createOutlet(outlet);

            if (outletId > 0) {

                out.println("<html><body> Outlet " + outletId
                        + " is added successfully !!</body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_OUTLET_PAGE);
            } else {
                out.println("<html><body> Outlet " + outletId
                        + " has not been added !! </body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_OUTLET_PAGE);
            }
        }

        // --------------------------------- Searching Outlet ----------------------------------------- //

        // ------------------------------ View Outlet --------------------------------------------- //

        else if ("viewoutlets".equalsIgnoreCase(action)) {
            outletList = adminServices.viewOutlet();

            request.setAttribute("outletList", outletList);

            GeneralMethods.RequestForward(request, response,
                    Constants.VIEW_ALL_OUTLETS_PAGE);
        }

        // ------------------------------ Update Outlet ---------------------------------------------- //

        // ------------------- Search by Outlet ID --------------------------- //

        else if ("searchoutlet".equalsIgnoreCase(action)) {
            outletId = Integer.parseInt(request.getParameter("outletid"));

            outlet = adminServices.searchOutlet(outletId);
            System.out.println(outlet.getState());
            request.setAttribute("outlet", outlet);
            GeneralMethods.RequestForward(request, response,
                    Constants.UPDATE_OUTLET_NAME);
        }

        // ------------------- Update Outlet Attributes ---------------------------- //

        else if ("updateoutlet".equalsIgnoreCase(action)) {
            System.out.println(request.getParameter("outletid"));
            outletId = Integer.parseInt(request.getParameter("outletid"));

            outlet.setAddress(request.getParameter("address"));
            outlet.setState(request.getParameter("state"));
            outlet.setCity(request.getParameter("city"));
            outlet.setZipCode(Long.parseLong(request.getParameter("zipcode")));

            updateCount = adminServices.updateOutlet(outlet, outletId);

            if (updateCount > 0) {

                out.println("<html><body> <p> Outlet is updated successfully !! <p></body></html> ");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_OUTLET_PAGE);
            } else {
                out.println("<html><body> Outlet is not updated <br></br> </body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_OUTLET_PAGE);
            }
        }

        // XXX------------------------------ Update Outlet ----------------------------------------------XXX //

        // ----------------------------- Delete Outlet --------------------------------------------- //

        else if ("deleteoutlet".equalsIgnoreCase(action)) {
            outletId = Integer.parseInt(request.getParameter("outletid"));

            updateCount = adminServices.deleteOutlet(outletId);

            if (updateCount > 0) {

                out.println("<html><body> Outlet " + outletId
                        + " is deleted successfully !!</body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_OUTLET_PAGE);
            } else {
                out.println("<html><body> Outlet  " + outletId
                        + " has not been deleted !! </body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_OUTLET_PAGE);
            }
        }

        // ----------------------------- Delete Selected Outlet
        // --------------------------------------------- //
        else if ("delete all".equalsIgnoreCase(action)) {

            System.out.println("inside delete");
            String[] outletIds = request.getParameterValues("selectid");

            if (outletIds != null) {
                ids = outletIds[0];
                for (int i = 1; i <= outletIds.length - 1; i++) {
                    // idList.add(Integer.parseInt(itemId[i]));
                    ids = ids + "," + outletIds[i];
                    System.out.println("inside for loop");

                }

                updateCount = adminServices.deleteAllOutlets(ids);

                if (updateCount > 0) {

                    out.println("<html><body style="
                            + "align:center"
                            + "> Outlets are deleted successfully !!</body></html>");
                    GeneralMethods.RequestInclude(request, response,
                            Constants.MANAGE_OUTLET_PAGE);
                     } else {
                    out.println("<html><body style=" + "align:center"
                            + "> Outlet   not  deleted !! </body></html>");
                    GeneralMethods.RequestInclude(request, response,
                            Constants.MANAGE_OUTLET_PAGE);
                }
            } else {
                out.println("<html><body style="
                        + "align:center"
                        + "> Outlet   not  deleted !!\nPlease select an item. </body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_OUTLET_PAGE);
            }
        }
        // XXX--------------------------------OUTLET MANAGEMENT----------------------------------------XXX //

        // ---------------------------------- DEPARTMENT MANAGEMENT ----------------------------------------- //

        // ---------------------- Adding Department -----------------------------------//

        else if ("adddepartment".equalsIgnoreCase(action)) {
            System.out.println("ANYONE??");

            department
                    .setDepartmentName(request.getParameter("departmentname"));

            departmentId = adminServices.createDepartment(department);
            if (departmentId > 0) {
                out.println("<html><body> Department "
                        + department.getDepartmentName()
                        + " is added successfully !!</body></html>");
                GeneralMethods.RequestInclude(request, response,
                        "JSP/managedepartment.jsp");
            } else {
                out.println("<html><body>  Department "
                        + department.getDepartmentName()
                        + "  already exist !! </body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_DEPARTMENT_PAGE);
            }
        }

        // ---------------------- Searching Department -----------------------------------//

        // ---------------------- View Department ----------------------------------- //

        else if ("viewdepartments".equalsIgnoreCase(action)) {
            departmentList = adminServices.viewDepartment();

            request.setAttribute("departmentList", departmentList);
            System.out.println(departmentList);
            GeneralMethods.RequestForward(request, response,
                    Constants.VIEW_ALL_DEPARTMENT_PAGE);
}

        // ------------------------------UPDATE DEPARTMENT----------------------------------------------//

        // ---------------------- Search by Department ID ----------------------------------- //

        else if ("searchdepartment".equalsIgnoreCase(action)) {

            departmentId = Integer.parseInt(request
                    .getParameter("departmentid"));

            department = adminServices.searchDepartment(departmentId);

            request.setAttribute("department", department);
            System.out.println(department.getDepartmentName());
            GeneralMethods.RequestForward(request, response,
                    Constants.SEARCH_DEPARTMENT);
        }

        // ------------------- Update Department Attributes ---------------------------- //

        else if ("updatedepartment".equalsIgnoreCase(action)) {
            departmentId = Integer.parseInt(request
                    .getParameter("departmentid"));
            department
                    .setDepartmentName(request.getParameter("departmentname"));
            updateCount = adminServices.updateDepartment(department,
                    departmentId);
            if (updateCount > 0) {
                out.println("<html><body> Department "
                        + department.getDepartmentName()
                        + " is updated successfully !!</body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_DEPARTMENT_PAGE);
            } else {
                out.println("<html><body>  Department  "
                        + department.getDepartmentName()
                        + " has not been updated !! </body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_DEPARTMENT_PAGE);
            }

        }

        // ----------------------------- Delete Department --------------------------------------------- //

        else if ("deletedepartment".equalsIgnoreCase(action)) {
            departmentId = Integer.parseInt(request
                    .getParameter("departmentid"));

            updateCount = adminServices.deleteDepartment(departmentId);

            if (updateCount > 0) {
                out.println("<html><body> Department " + departmentId
                        + " is deleted successfully !!</body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_DEPARTMENT_PAGE);
            } else {
                out.println("<html><body>  Department  " + departmentId
                        + " has not been deleted !! </body></html>");
                GeneralMethods.RequestInclude(request, response,
                        Constants.MANAGE_DEPARTMENT_PAGE);
            }
        }
    }
}