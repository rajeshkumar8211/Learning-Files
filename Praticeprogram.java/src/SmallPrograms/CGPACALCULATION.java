package SmallPrograms;
import java.util.*;
import java.sql.*;
class CGPACALACULATION  {
    static Scanner sc =new Scanner(System.in);
    static int ch;
    static double gpacal=0.0;
    static Connection con;
    {
        try {
            String url="jdbc:mysql://localhost:3306/cgpa";
            String username="root";
            String password="svmr";
            con = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void CgpaCal(String name,String register_no) throws Exception {  //CGPA CALCULATION
        int sems;
        char st = 0;
        double cgpa = 0.0, gpamark = 0.0,cg;
        int i;
        String sql;
        System.out.println("\nEnter your Semester");
        sems = sc.nextInt();
        for (i = 1; i <= sems; i++) {
            System.out.println("\nDo you know your past semester - " + i + " gpa(Y/N)");
            st = sc.next().toUpperCase().charAt(0);
            if (st == 'Y') {
                String sq = "select *  from cgpa where register_no = ? ";
                PreparedStatement rp = con.prepareStatement(sq);
                rp.setString(1, register_no);
                ResultSet rs = rp.executeQuery();
                if (rs.next()) {
                    sql = "update cgpa set cgpa = ?,stud_name = ? where register_no = ?";
                } else {
                    sql = "insert into cgpa (stud_name,register_no,cgpa) values(?,?,?) ";
                }
                PreparedStatement ps = con.prepareStatement(sql);
                System.out.println("Enter your semester -" + i + " gpa");
                gpamark = sc.nextDouble();
                gpamark = markcon(i, gpamark);
                cgpa += gpamark;
                cg=Cgpa(i,cgpa);
                ps.setString(1, name);
                ps.setString(2, register_no);
                ps.setDouble(3, cg);
                ps.executeUpdate();
            } else if (st == 'N') {
                String sq = "select *  from cgpa where register_no = ? ";
                PreparedStatement rp = con.prepareStatement(sq);
                rp.setString(1, register_no);
                ResultSet rs = rp.executeQuery();
                if (rs.next()) {
                    sql = "update cgpa set cgpa = ?,stud_name = ? where register_no = ?";
                } else {
                    sql = "insert into cgpa (stud_name,register_no,cgpa) values(?,?,?) ";
                }
                PreparedStatement ps = con.prepareStatement(sql);
                gpamark = Semester(i, name, register_no);
                cgpa += gpamark;
                cg=Cgpa(i,cgpa);
                ps.setString(1, name);
                ps.setString(2, register_no);
                ps.setDouble(3, cg);
                ps.executeUpdate();
            } else {
                System.out.println("SORRY YOU ENTER A WRONG LETTER \n\n THANK YOU");
                System.exit(0);
            }
        }
    }
    private static double Cgpa(int sems,double cgpa){
        switch (sems){
            case 1:{
                cgpa/=22;
                System.out.println("Your 1st semester gpa is your current cgpa"+cgpa);
                return cgpa;
            }
            case 2:{
                cgpa/=48;
                System.out.println("Your CGPA is :"+cgpa);
                return cgpa;
            }
            case 3:{
                cgpa/=71;
                System.out.println("Your CGPA is :"+cgpa);
                return cgpa;
            }
            case 4:{
                cgpa/=93;
                System.out.println("Your CGPA is :"+cgpa);
                return cgpa;
            }
            case 5:{
                cgpa/=113;
                System.out.println("Your CGPA is :"+cgpa);
                return cgpa;
            }
            case 6:{
                cgpa/=136;
                System.out.println("Your CGPA is :"+cgpa);
                return cgpa;
            }
            case 7:{
                cgpa/=152;
                System.out.println("Your CGPA is :"+cgpa);
                return cgpa;
            }
            case 8:{
                cgpa/=162;
                System.out.println("Your CGPA is :"+cgpa);
                return cgpa;
            }
        }
        return cgpa;
    }
    private static double markcon(int i,double gpamark){  //CONVERSATION FROM GPA TO MARK
        switch (i){
            case 1:{
                gpamark=gpamark*22;
                return gpamark;
            }
            case 2:{
                gpamark=gpamark*26;
                return gpamark;
            }
            case 3:{
                gpamark=gpamark*23;
                return gpamark;
            }
            case 4:{
                gpamark=gpamark*22;
                return gpamark;
            }
            case 5:{
                gpamark=gpamark*20;
                return gpamark;
            }
            case 6:{
                gpamark=gpamark*23;
                return gpamark;
            }
            case 7:{
                gpamark=gpamark*16;
                return gpamark;
            }
            case 8:{
                gpamark=gpamark*10;
                return gpamark;
            }
        }
        return 1.0;
    }
    private static double GpaCal(double semgpa,int totcre,int s){ //GPA CALCULATION
        semgpa=semgpa/totcre;
        System.out.println("Your semester -" + s +" gpa is " + semgpa);
        return semgpa;
    }
    private static double assignvalue(double cre){  //ASSIGN GRADE MARK
        String grade;
        double value =0.0,mark;
        System.out.println("\nEnter your grade");
        grade=sc.next().toUpperCase();
        switch (grade){
            case "O": {
                value=10.0;
                break;
            }
            case "A+": {
                value=9.0;
                break;
            }
            case "A": {
                value=8.0;
                break;
            }
            case "B+": {
                value=7.0;
                break;
            }
            case "B": {
                value=6.0;
                break;
            }
            case "C": {
                value=5.0;
                break;
            }
            case "U":{
                value=0.0;
                break;

            }
            default:{
                System.out.println("Please Enter a Valid Grade");
                break;
            }
        }
        mark=value*cre;
        gpacal+=mark;
        return gpacal;
    }
    private static double Semester(int s,String name,String register_no) throws Exception {
        double firstsem,g;
        if(s==0) {
            System.out.println("\nEnter your semester");
            s = sc.nextInt();
            Semester(s,name,register_no);
        }
        else{
            switch (s) {
                case 1: {
                    gpacal=0.0;
                    System.out.println("Enter your Professional English-I Grade (HS3152)");
                    assignvalue(3.0);
                    System.out.println("Enter your Matrices And Calculus Grade (MA3151)");
                    assignvalue(4.0);
                    System.out.println("Enter your Engineering Physics Grade (PH3151)");
                    assignvalue(3.0);
                    System.out.println("Enter your Engineering Chemistry Grade (CY3151)");
                    assignvalue(3.0);
                    System.out.println("Enter your Heritage Of Tamil Grade (GE3152)");
                    assignvalue(1.0);
                    System.out.println("Enter your Problem Solving And Python Programming Grade (GE3151)");
                    assignvalue(3.0);
                    System.out.println("Enter your Problem Solving And Python Programming Laboratory Grade (GE3171)");
                    assignvalue(2.0);
                    System.out.println("Enter your Physics And Chemistry Laboratory Grade (BS3171)");
                    assignvalue(2.0);
                    System.out.println("Enter your English Laboratory Grade (BS3171)");
                    firstsem = assignvalue(1.0);
                    g=GpaCal(firstsem, 22,s);
                    connection("first_sem",name,register_no,g);
                    return firstsem;
                }
                case 2: {
                    gpacal=0.0;
                    System.out.println("Enter your Professional English-II Grade (HS3252)");
                    assignvalue(2.0);
                    System.out.println("Enter your Statistics And Numerical Methods Grade (MA3251)");
                    assignvalue(4.0);
                    System.out.println("Enter your Physics For Information Science Grade (PH3256)");
                    assignvalue(3.0);
                    System.out.println("Enter your Basic Electrical And Electronics Engineering Grade (BE3151)");
                    assignvalue(3.0);
                    System.out.println("Enter your Engineering Graphics Grade (GE3251)");
                    assignvalue(4.0);
                    System.out.println("Enter your Programming In C Grade (CS3251)");
                    assignvalue(3.0);
                    System.out.println("Enter your Tamil And Technology Grade (GE3152)");
                    assignvalue(1.0);
                    System.out.println("Enter your Programming In C Laboratory Grade (CS3271)");
                    assignvalue(2.0);
                    System.out.println("Enter your Engineering Practices Laboratory Grade (GE3271)");
                    assignvalue(2.0);
                    System.out.println("Enter your Communication Laboratory/Foreign Laboratory Grade (GE3272)");
                    firstsem = assignvalue(2.0);
                    g=GpaCal(firstsem, 26,s);
                    connection("second_sem",name,register_no,g);
                    return firstsem;
                }
                case 3: {
                    gpacal=0.0;
                    System.out.println("Enter your Discrete Mathematics Grade (MA3354)");
                    assignvalue(4.0);
                    System.out.println("Enter your Digital Principles And Computer Organization Grade (CS3351)");
                    assignvalue(4.0);
                    System.out.println("Enter your Foundation  Of Data Science Grade (CS3352)");
                    assignvalue(3.0);
                    System.out.println("Enter your Data Structures Grade (CS3301)");
                    assignvalue(3.0);
                    System.out.println("Enter your Object Oriented And Programming Grade (CS3391)");
                    assignvalue(3.0);
                    System.out.println("Enter your Professional Development Grade (GE3361)");
                    assignvalue(1.0);
                    System.out.println("Enter your Data Structures Laboratory Grade (CS3311)");
                    assignvalue(1.5);
                    System.out.println("Enter your Data Science Laboratory Grade (CS3381)");
                    assignvalue(2.0);
                    System.out.println("Enter your Object Oriented And Programming Laboratory Grade (CS3361)");
                    firstsem = assignvalue(1.5);
                    g=GpaCal(firstsem, 23,s);
                    connection("third_sem",name,register_no,g);
                    return firstsem;
                }
                case 4: {
                    gpacal=0.0;
                    System.out.println("Enter your Theory Of Computation Grade (CS3452)");
                    assignvalue(3.0);
                    System.out.println("Enter your Artificial Intelligence And Machine Learning Grade (CS3491)");
                    assignvalue(4.0);
                    System.out.println("Enter your DataBase Management System Grade (CS3492)");
                    assignvalue(3.0);
                    System.out.println("Enter your Algorithms Grade (CS3401)");
                    assignvalue(4.0);
                    System.out.println("Enter your Introduction To Operating Systems Grade (CS3451)");
                    assignvalue(3.0);
                    System.out.println("Enter your Environmental Science And Sustainability Grade (GE3451)");
                    assignvalue(2.0);
                    System.out.println("Enter your Operating Systems Laboratory Grade (CS3461)");
                    assignvalue(1.5);
                    System.out.println("Enter your DataBase Management System Laboratory Grade (CS3481)");
                    firstsem=assignvalue(1.5);
                    g=GpaCal(firstsem, 22,s);
                    connection("fourth_sem",name,register_no,g);
                    return firstsem;
                }
                case 5:{
                    gpacal=0.0;
                    System.out.println("Enter your Computer Networks Grade (CS3591)");
                    assignvalue(4.0);
                    System.out.println("Enter your Compiler Design Grade (CS3501)");
                    assignvalue(4.0);
                    System.out.println("Enter your Cryptography and Cyber Security  Grade (CB3491)");
                    assignvalue(3.0);
                    System.out.println("Enter your Distributed Computing Grade (CS3551)");
                    assignvalue(3.0);
                    System.out.println("Enter your Professional Elective-I Grade ");
                    assignvalue(3.0);
                    System.out.println("Enter your Professional Elective-II Grade ");
                    firstsem=assignvalue(3.0);
                    g=GpaCal(firstsem, 20,s);
                    connection("fivith_sem",name,register_no,g);
                    return firstsem;
                }
                case 6:{
                    gpacal=0.0;
                    System.out.println("Enter your Object Oriented Software Engineering Grade (CCS356)");
                    assignvalue(4.0);
                    System.out.println("Enter your Embedded Systems And IOT Grade (CS3691)");
                    assignvalue(4.0);
                    System.out.println("Enter your Open Elective-I Grade");
                    assignvalue(3.0);
                    System.out.println("Enter your Professional Elective-III Grade");
                    assignvalue(3.0);
                    System.out.println("Enter your Professional Elective-IV Grade ");
                    assignvalue(3.0);
                    System.out.println("Enter your Professional Elective-V Grade ");
                    assignvalue(3.0);
                    System.out.println("Enter your Professional Elective-VI Grade ");
                    firstsem=assignvalue(3.0);
                    g=GpaCal(firstsem, 23,s);
                    connection("sixth_sem",name,register_no,g);
                    return firstsem;
                }
                case 7:{
                    gpacal=0.0;
                    System.out.println("Enter your Human Values And Ethics Grade (GE3791)");
                    assignvalue(2.0);
                    System.out.println("Enter your Elective Management Grade ");
                    assignvalue(3.0);
                    System.out.println("Enter your Open Elective-II Grade");
                    assignvalue(3.0);
                    System.out.println("Enter your Open Elective-III Grade");
                    assignvalue(3.0);
                    System.out.println("Enter your Open Elective-IV Grade ");
                    assignvalue(3.0);
                    System.out.println("Enter your Summer Internship Grade ");
                    firstsem=assignvalue(2.0);
                    g=GpaCal(firstsem, 16,s);
                    connection("seventh_sem",name,register_no,g);
                    return firstsem;
                }
                case 8:{
                    gpacal=0.0;
                    System.out.println("Enter your Project Work / Internship Grade ");
                    firstsem=assignvalue(10.0);
                    g=GpaCal(firstsem, 10,s);
                    connection("eigth_sem",name,register_no,g);
                    return firstsem;
                }
            }
        }
        return 1.0;
    }
    private static void connection (String columnname,String name,String register_no,double g) throws Exception{
        String sq ="select *  from gpa where register_no = ? ";
        PreparedStatement rp = con.prepareStatement(sq);
        rp.setString(1,register_no);
        ResultSet rs =rp.executeQuery();
        if(rs.next()){
            String sql="update gpa set "+columnname+" = ?,stud_name= ? where register_no = ?";
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setDouble(1,g);
            ps.setString(2,name);
            ps.setString(3,register_no);
            ps.executeUpdate();
        }else{
            String sql ="insert into gpa (stud_name,register_no,"+columnname+") values(?,?,?) ";
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,register_no);
            ps.setDouble(3,g);
            ps.executeUpdate();
        }
    }
        private void calculate() throws Exception{ // CALCULATION STARTS
        System.out.println("Enter your name:");
        String name= sc.nextLine();
        System.out.println("Enter your Register No:");
        String register_no= sc.nextLine();
        System.out.println("============\n\tMENU\n\n\t1.GPA\n\t2.CGPA\n============");
        System.out.println("\nEnter your choice to Calculate:");
        ch= sc.nextInt();
        if(ch==1){
            Semester(0,name,register_no);
        }
        else if (ch==2) {
            CgpaCal(name,register_no);
        }
        else {
            System.out.println("Please enter a valid choice");
        }
    }
    public static void main(String args[]) throws Exception{
        CGPACALACULATION cp = new CGPACALACULATION();
        cp.calculate();

    }
}