package com.example.cars;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.*;

import carscrud.CarsDao;
import carscrud.model.Cars;


@Controller
public class Home {
	List<String> c = new ArrayList<>();
	List<Mod> c3 = new ArrayList<>();
	Mod m1 = new Mod();
	List<String> carList = new ArrayList<>();
	List<String> c2 = new ArrayList<>();
	List<String> car_names = new ArrayList<>();
	List<String> c4 = new ArrayList<>();
	List<Integer> c5 = new ArrayList<>();
	List<naviL> c6 = new ArrayList<>();
	List<Mod> c7 = new ArrayList<>();
	Connection con;
	int n = 2;

//	@Autowired
//	private AutoDao cardao;
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index(Model m) {
		List<MyForm> names = new ArrayList<>();
		MyForm theform = new MyForm();
		theform.setCar_name("Honda");
		names.add(theform);
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj","root","Sakib@123");
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("select name from cars");
//			while(rs.next()) {
//				//c.add(rs.getString(1));
//				System.out.println("---->"+rs.getString(1));
//			}
//		}catch(Exception e) {
//			System.out.println("---->"+e.toString());
//		}
////		List<Autos> cars = cardao.getCars();
////		m.addAttribute("cars",c);
//		//System.out.println("---->"+cars);
//		m.addAttribute("cars",c);
		return "index";
		
	}	
	
	
	@RequestMapping("/2")
	public String addCars1(Model m,@ModelAttribute("carModel") carModel carModel) {
		c7.clear();
		m.addAttribute("car",carList);
		System.out.println("2"+carList);
		if(c3.size()%(n*2)==0) {
			
			for(int i=n;i<c3.size();i++) {
				Mod m2 = c3.get(i);
				c7.add(m2);
			}
			
			m.addAttribute("cars",c7);
			generate2(m);
			//generate(m,c3);
			//System.out.println("in if");
			return "one";
		}
		else {
			for(int i=n;i<=n+(n-1);i++) {
				Mod m2 = c3.get(i);
				c7.add(m2);
			}
			System.out.println("not in mod");
			m.addAttribute("cars",c7);
			System.out.println("in else of 1");
			generate2(m);
			//generate(m,c3);
			return "one";
		}
	}
	
	@RequestMapping("/3")
	public String addCars2(Model m,@ModelAttribute("carModel") carModel carModel) {
		c7.clear();
		m.addAttribute("car",carList);
		if(c3.size()%(n*3)==0) {
			for(int i=(n*2);i<c3.size();i++) {
				Mod m2 = c3.get(i);
				c7.add(m2);
			}
			generate2(m);
			m.addAttribute("cars",c7);
			//generate(m,c3);
			System.out.println("in if");
			return "one";
		}
		else {
			try {
			for(int i=n*2;i<=n*2+(n-1);i++) {
				Mod m2 = c3.get(i);
				c7.add(m2);
			}
			}catch(Exception e) {
				
			}
			generate2(m);
			m.addAttribute("cars",c7);
			//generate(m,c3);
			return "one";
		}
		
	}
	
	@RequestMapping("/4")
	public String addCars3(Model m,@ModelAttribute("carModel") carModel carModel) {
		c7.clear();
		m.addAttribute("car",carList);
		if(c3.size()%16!=0) {
			for(int i=12;i<c3.size();i++) {
				Mod m2 = c3.get(i);
				c7.add(m2);
			}
			generate2(m);
			m.addAttribute("cars",c7);
			//generate(m,c3);
			System.out.println("4444");
			return "one";
		}
		else {
			for(int i=12;i<16;i++) {
				Mod m2 = c3.get(i);
				c7.add(m2);
			}
			generate2(m);
			m.addAttribute("cars",c7);
			//generate(m,c3);
			return "one";
		}
	}
	
	@RequestMapping(value="search",method=RequestMethod.GET)
		public String selectedCars(@ModelAttribute("selectedCars") carModel carModel,Model m,@RequestParam String selectedCars) {
		//carModel mod1 = new carModel();
		//mod1.setSelectedCars("Honda");
		//m.addAttribute("selectedCars",mod1);
		m.addAttribute("car",carList);
		String car = carModel.getSelectedCars();
		System.out.println("in search "+selectedCars);
		try {
			//c3.clear();
			Class.forName("com.mysql.jdbc.Driver");
			c3.clear();
			c2.clear();
			c.clear();
			c5.clear();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj","root","Sakib@123");
			Statement st = con.createStatement();
			//ResultSet rs = st.executeQuery("select id,name,descr from cars where name = "+"'"+selectedCars+"'");
			ResultSet rs = st.executeQuery("select a.aid,a.name from auto a, category c where brand = "+"'"+selectedCars+"'"+" and a.id=c.id");
			while(rs.next()) {
				int i =0;
				Mod mod = new Mod();
				c5.add(rs.getInt(1));
				c.add(rs.getString(2));
				m1.setName(rs.getString(2));
				//c2.add(rs.getString(3));
				mod.setId(rs.getInt(1));
				mod.setName(rs.getString(2));
				mod.setDescr("3 Airbags");
				//c3.add(new Mod(rs.getString(2)));
				c3.add(mod);
				i++;
				//System.out.println("---->===="+rs.getString(2)+i);
			}
			con.close();
			}catch(Exception e) {
			System.out.println("---->"+e.toString());
		}
		m.addAttribute("cars",c3);
		return "new_page";
	}
	
	
	@RequestMapping("/add_car")
	public String addCars(@ModelAttribute("carModel") carModel carModel,Model m) {
		System.out.println("in add");
		c3.clear();
		c2.clear();
		c.clear();
		c5.clear();
		c6.clear();
		m.addAttribute("command");
		List<String> carList = new ArrayList<>();
		//carModel mod3 = new carModel();
	
		try {
			//c3.clear();
			Class.forName("com.mysql.jdbc.Driver");
			carList.clear();
			//car_names.clear();
			c3.clear();
			c2.clear();
			c.clear();
			c5.clear();
			c7.clear();
			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj","root","Sakib@123");
			Statement st = con2.createStatement();
//			ResultSet rs = st.executeQuery("select id,name,descr from cars");
//			//ResultSet rs2 = st.executeQuery("select type from categ");
//			while(rs.next()) {
//				int i =0;
//				Mod mod = new Mod();
//				c5.add(rs.getInt(1));
//				c.add(rs.getString(2));
//				m1.setName(rs.getString(2));
//				car_names.add(rs.getString(2));
//				//mod3.setSelectedCars(rs.getString(2));
//				carList.add(rs.getString(2));
//				c2.add(rs.getString(3));
//				mod.setId(rs.getInt(1));
//				mod.setName(rs.getString(2));
//				mod.setDescr(rs.getString(3));
//				//c3.add(new Mod(rs.getString(2)));
//				c3.add(mod);
//				i++;
//				//System.out.println("---->===="+rs.getString(2)+i);
//			}
			ResultSet rs = st.executeQuery("select * from auto");
			while(rs.next()) {
				Mod mod = new Mod();
				mod.setId(rs.getInt(1));
				mod.setName(rs.getString(2));
				mod.setDescr("3 Airbags");
				c3.add(mod);
			}
			ResultSet rs2 = st.executeQuery("select brand from category");
			while(rs2.next()) {
				carList.add(rs2.getString(1));			}
		}
		
		catch(Exception e) {
			System.out.println("---->"+e.toString());
		}
		//carList.add("Toyota");
		m.addAttribute("car",carList);
		generate(m,c3);
	
		m.addAttribute("cars",c7);
		return "add_car";
	}
	
	@RequestMapping("/Toyota")
	public String descriptionToyota(Model m) {
		
		return "Toyota";
	}
	
	@RequestMapping("/Honda")
	public String descriptionHonda(Model m) {
		
		return "Honda";
	}
	
	public void generate(Model m,List<Mod> cr) {
		if(cr.size()%n==0) {
			
			
			c6.clear();
			int temp = cr.size()/n;
			System.out.println("---->else--->"+temp);
			//naviL n = new naviL();
			if(temp==0) {
				c6.add(new naviL(1));
				m.addAttribute("navi",c6);
				for(int i=0;i<n;i++) {
					Mod m3 = cr.get(i);
					c7.add(m3);
					
				}
			}
			else {
				for(int i=1;i<=temp;i++) {
					
					System.out.println("in for"+i);
					c6.add(new naviL(i+1));
				}
				m.addAttribute("navi",c6);
				for(int i=0;i<c6.size();i++) {
					System.out.println("iter"+c6.get(i).getIter());
				}
				for(int i=0;i<n;i++) {
					Mod m3 = cr.get(i);
					c7.add(m3);
					
				}
			}
		}
		else {
			c6.clear();
			int temp = cr.size()/n;
			System.out.println("---->mod---->"+temp);
			//naviL n = new naviL();
			if(temp==0) {
				System.out.println("true");
				c6.add(new naviL(1));
				m.addAttribute("navi",c6);
				for(int i=0;i<cr.size();i++) {
					Mod m3 = cr.get(i);
					c7.add(m3);
					
				}
			}
			else {
					for(int i=1;i<=temp;i++) {
					
					System.out.println("in for"+i);
					c6.add(new naviL(i+1));
				}
				m.addAttribute("navi",c6);
				for(int i=0;i<c6.size();i++) {
					System.out.println("iter"+c6.get(i).getIter());
				}
				for(int i=0;i<4;i++) {
					Mod m3 = cr.get(i);
					c7.add(m3);
					
				}
			}
			
			
		}
	}
	
	public void generate2(Model m) {
		if(c3.size()%n!=0) {
			c6.clear();
			int temp = c3.size()/n;
			System.out.println("---->"+temp);
			//naviL n = new naviL();
			for(int i=1;i<=temp;i++) {
				
				System.out.println("in for"+i);
				c6.add(new naviL(i+1));
			}
			m.addAttribute("navi",c6);
			for(int i=0;i<c6.size();i++) {
				System.out.println("iter"+c6.get(i).getIter());
			}
			
		}
		else {
			c6.clear();
			int temp = c3.size()/n;
			System.out.println("---->"+temp);
			//naviL n = new naviL();
			for(int i=1;i<=temp;i++) {
				
				System.out.println("in for"+i);
				c6.add(new naviL(i+1));
			}
			m.addAttribute("navi",c6);
			for(int i=0;i<c6.size();i++) {
				System.out.println("iter"+c6.get(i).getIter());
			}
			
		}
	}
	
	@RequestMapping("/new_page")
	public String home(@ModelAttribute("carModel") carModel carModel,Model m) {
//		//m.addAttribute("cname", cname);
//		//m.addAttribute("myform", new MyForm());
//		//String car_name="Honda";
//		c3.clear();
//		c2.clear();
//		c.clear();
//		c5.clear();
//		try {
//			//c3.clear();
//			Class.forName("com.mysql.jdbc.Driver");
//			c3.clear();
//			c2.clear();
//			c.clear();
//			c5.clear();
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj","root","Sakib@123");
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("select id,name,descr from cars where name = "+"'"+cname+"'");
//			while(rs.next()) {
//				int i =0;
//				Mod mod = new Mod();
//				c5.add(rs.getInt(1));
//				c.add(rs.getString(2));
//				m1.setName(rs.getString(2));
//				c2.add(rs.getString(3));
//				mod.setId(rs.getInt(1));
//				mod.setName(rs.getString(2));
//				mod.setDescr(rs.getString(3));
//				//c3.add(new Mod(rs.getString(2)));
//				c3.add(mod);
//				i++;
//				//System.out.println("---->===="+rs.getString(2)+i);
//			}
//		}catch(Exception e) {
//			System.out.println("---->"+e.toString());
//		}
//		m.addAttribute("cars",c3);
//		return "add_car";
//		//return "add_car";
		System.out.println("in add");
		c3.clear();
		c2.clear();
		c.clear();
		c5.clear();
		c6.clear();
		m.addAttribute("command");
		//carModel mod3 = new carModel();
	
		try {
			//c3.clear();
			Class.forName("com.mysql.jdbc.Driver");
			carList.clear();
			//car_names.clear();
			c3.clear();
			c2.clear();
			c.clear();
			c5.clear();
			c7.clear();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj","root","Sakib@123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select id,name,descr from cars");
			//ResultSet rs2 = st.executeQuery("select type from categ");
			while(rs.next()) {
				int i =0;
				Mod mod = new Mod();
				c5.add(rs.getInt(1));
				c.add(rs.getString(2));
				m1.setName(rs.getString(2));
				car_names.add(rs.getString(2));
				//mod3.setSelectedCars(rs.getString(2));
				carList.add(rs.getString(2));
				c2.add(rs.getString(3));
				mod.setId(rs.getInt(1));
				mod.setName(rs.getString(2));
				mod.setDescr(rs.getString(3));
				//c3.add(new Mod(rs.getString(2)));
				c3.add(mod);
				i++;
				//System.out.println("---->===="+rs.getString(2)+i);
			}
		}catch(Exception e) {
			System.out.println("---->"+e.toString());
		}
		
		//carList.add("Toyota");
		m.addAttribute("car",carList);
		generate(m,c3);
	
		m.addAttribute("cars",c7);
		return "new_page";
	}
	
	@RequestMapping("/Mitsubushi")
	public String descriptionMitsubishi(Model m) {
		
		return "Mitsubishi";
	}
	
	@RequestMapping("/Mercedes")
	public String descriptionMercedes(Model m) {
		
		return "Mercedes";
	}
	
	
}