package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.POJO.Items;
import com.tcs.ilp.Util.Constants;
import com.tcs.ilp.Util.Dbutil;

public class ItemDao implements Constants {

int count = 0;

/*
 * creating database connection. Initialize prepared statements
 */
Connection con = null;

PreparedStatement ps = null;

ResultSet rs = null;

// add a new item in item table
public int additems(Items items) {
    // TODO Auto-generated method stub
    con = Dbutil.getConnection();
    PreparedStatement ps1 = null;
    /*
     * Sql query to insert into Item Table with item sequence. query to select
     * item it from item table.
     */
    /*
     * String query=
     * "INSERT INTO ITEM_F (ITEMID,ITEMNAME,DEPARTMENTID,PRICE,QUANTITY) VALUES (ITEMSEQUENCE.NEXTVAL,?,?,?,?)"
     * ; String query2="SELECT ITEMSEQUENCE.CURRVAL FROM DUAL"; String
     * query3="SELECT ITEMNAME FROM ITEM_F WHERE ITEMNAME=?";
     */
    // inserting and retrieve data

    try {
        ps = con.prepareStatement(SELECTITEMBYNAME);
        ps.setString(1, items.getItemName().toUpperCase());
        if (!ps.executeQuery().next()) {

            ps = con.prepareStatement(ADDITEM);

            ps.setString(1, items.getItemName().toUpperCase());
            ps.setInt(2, items.getDepartmentId());
            ps.setDouble(3, items.getPrice());
            ps.setDouble(4, items.getQuantity());
            ps.execute();
        } else {
            return 0;
        }

        ps1 = con.prepareStatement(SELECTITEMSEQUENCE);

        rs = ps1.executeQuery();

        con.commit();
        if (rs != null) {

            while (rs.next()) {

                items.setItemId(rs.getInt(1));

            }

        } else {
            System.out.println("rs is null" + "::" + "Item not added.");
        }

    } catch (SQLException e) {

        e.printStackTrace();
    }

    finally {
        // closing the statements and connection
        Dbutil.closeAll(con, rs, ps, ps1);
        /*
         * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
         * Dbutil.closeStatement(ps1); Dbutil.closeConnection(con);
         */
    }

    return items.getItemId();
}

// checking whether item exists or not
/*
 * public boolean searchItem(String name){ con=Dbutil.getConnection(); boolean
 * check=false; String
 * query3="SELECT ITEMNAME FROM ITEM_F WHERE ITEMNAME='"+name+"'";
 * 
 * 
 * try{
 * 
 * ps=con.prepareStatement(query3); rs=ps.executeQuery(); while(rs.next()) {
 * System.out.println(check); check=true; }
 * 
 * }catch(SQLException e){
 * 
 * e.printStackTrace(); } finally{ //closing the statements and connection
 * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
 * Dbutil.closeConnection(con); } return check; }
 */

// delete selected item

public int deleteAllItems(String name) {
    con = Dbutil.getConnection();
    // boolean check=false;
    System.out.println(name);
    String query3 = "DELETE ITEM_F WHERE ITEMID IN (" + name + ")";

    try {
        ps = con.prepareStatement(query3);
        // ps.setString(1, name);

        count = ps.executeUpdate();
        con.commit();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    finally {
        // closing the statements and connection
        Dbutil.closeAll(con, rs, ps);
        /*
         * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
         * Dbutil.closeConnection(con);
         */
    }

    return count;
}

// view all items
public ArrayList<Items> viewitems() {
    con = Dbutil.getConnection();

    ArrayList<Items> itemsList = new ArrayList<Items>();

    try {
        ps = con.prepareStatement(VIEWAllITEMS);
        rs = ps.executeQuery();

        while (rs.next()) {
            Items items = new Items();
            items.setItemId(rs.getInt("ITEMID"));
            items.setItemName(rs.getString("ITEMNAME"));
            items.setDepartmentId(rs.getInt("DEPARTMENTID"));
            items.setPrice(rs.getDouble("PRICE"));
            items.setQuantity(rs.getDouble("QUANTITY"));

            itemsList.add(items);

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    finally {
        // closing the statements and connection
        Dbutil.closeAll(con, rs, ps);
        /*
         * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
         * Dbutil.closeConnection(con);
         */
    }

    return itemsList;
}

// search for a specific item by providing the item id
public Items searchitems(int i) {
    con = Dbutil.getConnection();
    Items items = new Items();
    try {
        ps = con.prepareStatement(SELECTITEMBYID);
        ps.setInt(1, i);
        rs = ps.executeQuery();

        while (rs.next()) {
            items.setItemId(rs.getInt("ITEMID"));
            items.setItemName(rs.getString("ITEMNAME"));
            items.setDepartmentId(rs.getInt("DEPARTMENTID"));
            items.setPrice(rs.getDouble("PRICE"));
            items.setQuantity(rs.getDouble("QUANTITY"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // closing the statements and connection
        Dbutil.closeAll(con, rs, ps);
        /*
         * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
         * Dbutil.closeConnection(con);
         */
    }

    return items;
}

// update items
public int updateitems(Items items) {
    con = Dbutil.getConnection();
    // update item record
    try {
        ps = con.prepareStatement(UPDATEITEM);
        ps.setString(1, items.getItemName().toUpperCase());
        ps.setInt(2, items.getDepartmentId());
        ps.setDouble(3, items.getPrice());
        ps.setDouble(4, items.getQuantity());

        ps.setInt(5, items.getItemId());

        count = ps.executeUpdate();
        con.commit();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    finally {
        // closing the statements and connection
        Dbutil.closeAll(con, rs, ps);
        /*
         * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
         * Dbutil.closeConnection(con);
         */
    }

    return count;
}

// delete a specific item
public int deleteitems(int itemid) {
    // TODO Auto-generated method stub
    con = Dbutil.getConnection();
    // delete item table record based on given id
    try {
        ps = con.prepareStatement(DELETEITEM);
        ps.setInt(1, itemid);

        count = ps.executeUpdate();
        con.commit();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    finally {
        // closing the statements and connection
        Dbutil.closeAll(con, rs, ps);
        /*
         * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
         * Dbutil.closeConnection(con);
         */
    }

    return count;
}

public int updateItemQuantity(int itemids, double quantity) {
    // TODO Auto-generated method stub

    con = Dbutil.getConnection();
    String UPDATEITEM = "update item_f set quantity=" + quantity
            + " where itemid=" + itemids;
    // update item record
    try {
        ps = con.prepareStatement(UPDATEITEM);
        count = ps.executeUpdate();
        con.commit();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    finally {
        // closing the statements and connection
        Dbutil.closeAll(con, rs, ps);
        /*
         * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
         * Dbutil.closeConnection(con);
         */
    }

    return count;

}

}
