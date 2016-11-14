package com.tcs.ilp.Util;

public interface Constants {
    // ---------------------------Customer
    // Constants------------------------------------------------------//
    static final String CUSTOMERVIEWALL          = "SELECT * from USER_REGISTRATION_F where category='CUSTOMER' ORDER BY ID";

    static final String CUSTOMERDELETE           = "DELETE USER_REGISTRATION_F where ID=?";

    static final String CUSTOMERSELECT           = "SELECT * from USER_REGISTRATION_F where ID=";

    // ---------------------------ITEM
    // Constants------------------------------------------------------//

    static final String ADDITEM                  = "INSERT INTO ITEM_F (ITEMID,ITEMNAME,DEPARTMENTID,PRICE,QUANTITY) VALUES (SEQUENCEITEMID.NEXTVAL,?,?,?,?)";

    static final String SELECTITEMSEQUENCE       = "SELECT SEQUENCEITEMID.CURRVAL FROM DUAL";

    static final String SELECTITEMBYNAME         = "SELECT ITEMNAME FROM ITEM_F WHERE ITEMNAME=?";

    // String DELETEAllITEM = "DELETE ITEM_F WHERE ITEMID IN (?)";

    static final String VIEWAllITEMS             = "SELECT * FROM ITEM_F ORDER BY ITEMID";

    static final String SELECTITEMBYID           = "SELECT * FROM ITEM_F WHERE ITEMID=?";

    static final String UPDATEITEM               = "UPDATE ITEM_F SET ITEMNAME=?,DEPARTMENTID=?,PRICE=?,QUANTITY=? WHERE ITEMID=? ";

    static final String DELETEITEM               = "DELETE ITEM_F WHERE ITEMID=? ";

    // ---------------------------DEPARTMENT
    // Constants------------------------------------------------------//

    static final String ADDDEPARTMENT            = "INSERT INTO DEPARTMENT_F (DEPARTMENTID,DEPARTMENTNAME) VALUES (SEQUENCEDEPARTMENTID.NEXTVAL,?)";

    static final String SELECTDEPARTMENTBYNAME   = "SELECT * FROM DEPARTMENT_F WHERE DEPARTMENTNAME=?";

    static final String SELECTDEPARTMENTSEQUENCE = "SELECT SEQUENCEDEPARTMENTID.CURRVAL AS DEPARTMENTID FROM DUAL";

    static final String VIEWDEPARTMENT           = "SELECT * FROM DEPARTMENT_F ORDER BY DEPARTMENTID";

    static final String UPDATEDEPARTMENT         = "UPDATE DEPARTMENT_F SET DEPARTMENTNAME=? WHERE DEPARTMENTID=?";

    static final String DELETEDEPARTMENT         = "DELETE DEPARTMENT_F WHERE DEPARTMENTID=?";

    static final String SELECTDEPARTMENTBYID     = "SELECT * FROM DEPARTMENT_F WHERE DEPARTMENTID=?";

    // ---------------------------OUTLET
    // Constants------------------------------------------------------//

    static final String ADDOUTLET                = "insert into OUTLET_F (outletid,ADDress,state,city,zipcode) values(SEQUENCEOUTLETID.nextval,?,?,?,?)";

    static final String SELECTOUTLETSEQUENCE     = "SELECT SEQUENCEOUTLETID.currval as outletid from dual";

    static final String VIEWOUTLETBYID           = "SELECT * from OUTLET_F order by outletid";

    static final String UPDATEOUTLET             = "UPDATE OUTLET_F set ADDress=?,state=?,city=?,zipcode=? where outletid=?";

    static final String DELETEOUTLET             = "DELETE OUTLET_F where outletid=?";

    static final String SELECTOUTLETBYID         = "select * from OUTLET_F where outletid=?";

    // String DELETEALLOUTLET="DELETE OUTLET_F WHERE outletid IN (?)";

    //Constans for JSP locations.
    static final String ADMIN_PAGE = "JSP/admin.jsp";
    static final String HOME_PAGE = "JSP/home.jsp";
    static final String LOGIN_PAGE = "JSP/Login1.jsp";
    static final String MANAGE_ITEM_PAGE = "JSP/manageitems.jsp";
    static final String VIEW_ITEMS_PAGE = "JSP/viewitems.jsp";
    static final String SEARCH_ITEM_RESULT_PAGE = "JSP/searchitemsresult.jsp";
    static final String DELETE_ITEM_VIEW_PAGE = "JSP/deleteitemsView.jsp";
    static final String VIEW_CUSTOMER_DETAILS_PAGE = "JSP/viewcustomersdetail.jsp";
    static final String VIEW_CUSTOMER_DELETE_PAGE = "JSP/viewCustomerDelete.jsp";
    static final String MANAGE_CUSTOMER_PAGE = "JSP/managecustomer.jsp";
    static final String MANAGE_OUTLET_PAGE = "JSP/manageoutlets.jsp";
    static final String VIEW_ALL_OUTLETS_PAGE = "/JSP/viewAllOutlets.jsp";
    static final String UPDATE_OUTLET_NAME = "/JSP/updateOutlet.jsp";
    static final String MANAGE_DEPARTMENT_PAGE = "JSP/managedepartment.jsp";
    static final String VIEW_ALL_DEPARTMENT_PAGE = "/JSP/viewAllDepartments.jsp";
    static final String SEARCH_DEPARTMENT = "/JSP/searchDepartment.jsp";
    static final String ITEMS_IN_DEPARTMENT_PAGE = "JSP/itemsindepartment.jsp";
    static final String WELCOME_PAGE = "/JSP/welcome.jsp";
    static final String CART_VIEW_PAGE = "JSP/CartView.jsp";
    static final String CREATE_RESULT_PAGE = "/jsp/createResult.jsp";
    static final String ORDER_PAGE = "/JSP/Order.jsp";
    static final String VIEW_BILLING_PAGE = "/JSP/viewBillingPage.jsp";
    static final String PAYMENT_GATEWAY_PAGE = "/JSP/viewBillingPage.jsp";
    static final String VIEW_YOUR_PROFILE_PAGE = "JSP/viewUrProfile.jsp";
    static final String UPDATE_FORM_PAGE = "JSP/updateform.jsp";
    static final String VIEW_ORDER_PAGE = "JSP/vieworders.jsp";
    
}
