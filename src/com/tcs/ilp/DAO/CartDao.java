package com.tcs.ilp.DAO;

import com.tcs.ilp.POJO.Cart;
import com.tcs.ilp.POJO.Items;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.Util.Dbutil;

public class CartDao {

java.sql.Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;
int cartCount = 0;

public int addCartItem(Cart cart) {
    System.out.println("into add cart");
    String createCartQuery = "insert into cart_f (cartid,id,itemid,quantity)"
            + "values(cart_fsequence.nextval,?,?,?)";
    try {
        con = Dbutil.getConnection();
        ps = con.prepareStatement(createCartQuery);
        ps.setInt(1, cart.getCustomerId());
        ps.setInt(2, cart.getItemId());
        ps.setDouble(3, cart.getQuantity());
        System.out.println(cart.getQuantity());

        cartCount = ps.executeUpdate();

        con.commit();

    } catch (SQLException e) {
        System.out.println("Exception is occured during creating cart");
        e.printStackTrace();
    } finally {
        Dbutil.closeAll(con, rs, ps);
        /*
         * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
         * Dbutil.closeConnection(con);
         */
    }

    return cartCount;
}

public int deleteCart(int Id) {
    String deleteCartQuery = "delete cart_f where id=?";
    try {
        con = Dbutil.getConnection();
        ps = con.prepareStatement(deleteCartQuery);
        ps.setInt(1, Id);

        cartCount = ps.executeUpdate();

        con.commit();

    } catch (SQLException e) {
        System.out.println("Exception is occured during creating customer");
        e.printStackTrace();
    } finally {
        Dbutil.closeAll(con, rs, ps);
    }

    return cartCount;

}

public ArrayList<Items> viewCart(int customerId) {
    int itemId = 0;
    ResultSet rs1 = null;
    ArrayList<Items> itemCart = new ArrayList<Items>();
    String viewCartQuery = "select itemid from cart_f where id=?";
    String viewItemCart = "select * from item_f where itemid=? order by departmentid";
    try {
        con = Dbutil.getConnection();
        ps = con.prepareStatement(viewCartQuery);
        ps.setInt(1, customerId);

        rs = ps.executeQuery();

        while (rs.next()) {
            itemId = rs.getInt("itemid");

            ps = con.prepareStatement(viewItemCart);
            ps.setInt(1, itemId);
            rs1 = ps.executeQuery();

            System.out.println(itemId);

            while (rs1.next()) {
                Items item = new Items();
                item.setItemId(rs1.getInt("itemid"));
                item.setItemName(rs1.getString("itemname"));
                item.setDepartmentId(rs1.getInt("departmentid"));
                item.setPrice(rs1.getDouble("price"));
                item.setQuantity(rs1.getDouble("quantity"));
                itemCart.add(item);
                System.out.println(item.getItemId());
            }
        }
        con.commit();

    } catch (SQLException e) {
        System.out.println("Exception is occured during creating cart");
        e.printStackTrace();
    } finally {
        Dbutil.closeAll(con, rs, ps);
        /*
         * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
         * Dbutil.closeConnection(con);
         */
    }

    return itemCart;

}

public Cart retreiveItem(int itemId, int Id) {
    Items item = new Items();
    Cart cart = new Cart();
    String retreiveItem = "select * from item_f where itemid=? ";
    try {
        con = Dbutil.getConnection();
        ps = con.prepareStatement(retreiveItem);
        ps.setInt(1, itemId);

        rs = ps.executeQuery();

        while (rs.next()) {
            /*
             * item.setItemId(rs.getInt("itemid"));
             * item.setItemName(rs.getString("itemname"));
             * item.setDepartmentId(rs.getInt("departmentid"));
             * item.setPrice(rs.getDouble("price"));
             * item.setQuantity(rs.getDouble("quantity"));
             */
            cart.setItemId(rs.getInt("itemid"));
            cart.setQuantity(rs.getDouble("quantity"));
            // HAVE TO THINK ABOUT HOW TO RETREIVE THE CUSTOMER ID
            cart.setCustomerId(Id);
            cart.setCartId(rs.getInt("cartId"));
        }
        con.commit();
    } catch (SQLException e) {
        System.out.println("Exception is occured during creating item");
        e.printStackTrace();
    } finally {
        Dbutil.closeAll(con, rs, ps);
        /*
         * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
         * Dbutil.closeConnection(con);
         */

    }
    /*
     * cart.setItemId(item.getItemId()); cart.setQuantity(item.getQuantity());
     * // HAVE TO THINK ABOUT HOW TO RETREIVE THE CUSTOMER ID
     * cart.setCustomerId(Id);
     */
    System.out.println(cart.getCustomerId());//
    // /
    return cart;

}

public Cart retreiveItembyCart(int itemId, int Id) {
    Items item = new Items();
    Cart cart = new Cart();
    String retreiveItem = "select * from cart_f where itemid=? ";
    try {
        con = Dbutil.getConnection();
        ps = con.prepareStatement(retreiveItem);
        ps.setInt(1, itemId);

        rs = ps.executeQuery();

        while (rs.next()) {
            /*
             * item.setItemId(rs.getInt("itemid"));
             * item.setItemName(rs.getString("itemname"));
             * item.setDepartmentId(rs.getInt("departmentid"));
             * item.setPrice(rs.getDouble("price"));
             * item.setQuantity(rs.getDouble("quantity"));
             */
            cart.setItemId(rs.getInt("itemid"));
            cart.setQuantity(rs.getDouble("quantity"));
            // HAVE TO THINK ABOUT HOW TO RETREIVE THE CUSTOMER ID
            cart.setCustomerId(Id);
            cart.setCartId(rs.getInt("cartId"));
        }
        con.commit();
    } catch (SQLException e) {
        System.out.println("Exception is occured during creating item");
        e.printStackTrace();
    } finally {
        Dbutil.closeAll(con, rs, ps);
        /*
         * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
         * Dbutil.closeConnection(con);
         */

    }
    /*
     * cart.setItemId(item.getItemId()); cart.setQuantity(item.getQuantity());
     * // HAVE TO THINK ABOUT HOW TO RETREIVE THE CUSTOMER ID
     * cart.setCustomerId(Id);
     */
    System.out.println(cart.getCustomerId());//
    // /
    return cart;

}

public void updateCartQuantity(int customerId, double quantity, int itemid) {

    String sql = "update cart_f set quantity=? where id=? and itemid=?";

    try {
        System.out.println(quantity + "::" + customerId);
        con = Dbutil.getConnection();
        ps = con.prepareStatement(sql);
        ps.setDouble(1, quantity);
        ps.setInt(2, customerId);
        ps.setInt(3, itemid);

        ps.executeUpdate();
        con.commit();

    } catch (SQLException e) {
        System.out.println("Exception is occured during creating item");
        e.printStackTrace();
    } finally {
        Dbutil.closeAll(con, rs, ps);
        /*
         * Dbutil.closeResultSet(rs); Dbutil.closeStatement(ps);
         * Dbutil.closeConnection(con);
         */
    }
}
}