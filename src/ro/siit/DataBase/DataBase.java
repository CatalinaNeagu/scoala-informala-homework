package ro.siit.DataBase;

import java.sql.*;

public class DataBase {

    public static void main(String[] args) {
        displayDataForAllClasses();
        displayDataForACourse();
        displayDataForClassesWhoseTitleBeginsWithIntro();
        displayDataForClassesWhoseDeptIsCosAndWhoseCoursenumBeginsWith3();
        displayDataForClassesWhoseProfnameBeginsWithCos();
    }

    public static void displayDataForAllClasses() {
        Connection conn = getConnection("mysql", "localhost", "3306", "school", "root", "MOIcata170");
        if (conn == null) return;


        Statement st = null;
        ResultSet rs = null;
        String format = "|%-20s|%20s|%20s|%20s|%20s|%20s|%20s|\n";

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from classes");
            while (rs.next()) {
                int classid = rs.getInt("classid");
                int courseid = rs.getInt("courseid");
                int days = rs.getInt("days");
                Time starttime = rs.getTime("starttime");
                Time endtime = rs.getTime("endtime");
                String bldg = rs.getString("bldg");
                int roomnum = rs.getInt("roomnum");

                System.out.format(format, classid, courseid, days, starttime, endtime, bldg, roomnum);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void displayDataForACourse() {
        Connection conn = getConnection("mysql", "localhost", "3306", "school", "root", "MOIcata170");
        if (conn == null) return;


        Statement st = null;
        ResultSet rs = null;
        String format = "|%-20s|%20s|%20s|%20s|%20s|\n";

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from courses where courseid = 3");
            while (rs.next()) {
                int courseid = rs.getInt("courseid");
                String area = rs.getString("area");
                String title = rs.getString("title");
                String descrip = rs.getString("descrip");
                int prereqs = rs.getInt("prereqs");

                System.out.format(format, courseid, area, title, descrip, prereqs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void displayDataForClassesWhoseTitleBeginsWithIntro() {
        Connection conn = getConnection("mysql", "localhost", "3306", "school", "root", "MOIcata170");
        if (conn == null) return;


        Statement st = null;
        ResultSet rs = null;
        String format = "|%-12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|\n";

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from classes join courses on classes.courseid = courses.courseid where lower(courses.title) like \"intro%\"");
            while (rs.next()) {
                int classid = rs.getInt("classid");
                int courseid = rs.getInt("courseid");
                int days = rs.getInt("days");
                Time starttime = rs.getTime("starttime");
                Time endtime = rs.getTime("endtime");
                String bldg = rs.getString("bldg");
                int roomnum = rs.getInt("roomnum");
                courseid = rs.getInt("courseid");
                String area = rs.getString("area");
                String title = rs.getString("title");
                String descrip = rs.getString("descrip");
                int prereqs = rs.getInt("prereqs");

                System.out.format(format, classid, courseid, days, starttime, endtime, bldg, roomnum, courseid, area, title, descrip, prereqs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void displayDataForClassesWhoseDeptIsCosAndWhoseCoursenumBeginsWith3() {
        Connection conn = getConnection("mysql", "localhost", "3306", "school", "root", "MOIcata170");
        if (conn == null) return;


        Statement st = null;
        ResultSet rs = null;
        String format = "|%-12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|\n";

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from classes join crosslistings on classes.courseid = crosslistings.courseid where lower(crosslistings.dept) = \"cos\" and crosslistings.coursenum like \"3%\"");
            while (rs.next()) {
                int classid = rs.getInt("classid");
                int courseid = rs.getInt("courseid");
                int days = rs.getInt("days");
                Time starttime = rs.getTime("starttime");
                Time endtime = rs.getTime("endtime");
                String bldg = rs.getString("bldg");
                int roomnum = rs.getInt("roomnum");
                courseid = rs.getInt("courseid");
                String dept = rs.getString("dept");
                int coursenum = rs.getInt("coursenum");

                System.out.format(format, classid, courseid, days, starttime, endtime, bldg, roomnum, courseid, dept, coursenum);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayDataForClassesWhoseProfnameBeginsWithCos() {
        Connection conn = getConnection("mysql", "localhost", "3306", "school", "root", "MOIcata170");
        if (conn == null) return;


        Statement st = null;
        ResultSet rs = null;
        String format = "|%-12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|\n";

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from classes \n" +
                    "join coursesprofs on classes.courseid = coursesprofs.courseid \n" +
                    "join profs on profs.profid = coursesprofs.profid where lower(profs.profname) like \"cos%\"");
            while (rs.next()) {
                int classid = rs.getInt("classid");
                int courseid = rs.getInt("courseid");
                int days = rs.getInt("days");
                Time starttime = rs.getTime("starttime");
                Time endtime = rs.getTime("endtime");
                String bldg = rs.getString("bldg");
                int roomnum = rs.getInt("roomnum");
                courseid = rs.getInt("courseid");
                int profid = rs.getInt("profid");
                profid = rs.getInt("profid");
                String profname = rs.getString("profname");

                System.out.format(format, classid, courseid, days, starttime, endtime, bldg, roomnum, courseid, profid, profid, profname);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(String dbType, String host, String port, String dbName, String userName, String password) {
        Connection conn = null;
        DriverManager.setLoginTimeout(60);

        try {
            StringBuilder connectionUrl = new StringBuilder();
            connectionUrl.append("jdbc:");
            connectionUrl.append(dbType);
            connectionUrl.append("://");
            connectionUrl.append(host);
            connectionUrl.append(":");
            connectionUrl.append(port);
            connectionUrl.append("/");
            connectionUrl.append(dbName);
            connectionUrl.append("?user=");
            connectionUrl.append(userName);
            connectionUrl.append("&password=");
            connectionUrl.append(password);

            return DriverManager.getConnection(connectionUrl.toString());
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());

        }
        return null;
    }
}
