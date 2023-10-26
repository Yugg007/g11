package com.g11.g11.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g11.g11.model.Car;
import com.g11.g11.model.User;
import com.g11.g11.services.CarService;
import com.g11.g11.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class CarController {
    @Autowired
    private UserService us;
    @Autowired
    private CarService cs;
    

    @GetMapping("/getSessionAttribute")
    public String getSessionAttribute(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return username;
    }
    
    @PostMapping("/login")
    public String login(HttpServletRequest req) {
        System.out.println("login mapping");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " " + password);
        Boolean isLoggedIn = us.handleLogin(new User(username, password));

        if (isLoggedIn == true) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            return "<script>alert('Successfully logged in.'); window.location.href='/homepage';</script>";
        } else {
            return "<script>alert('Login failed.'); window.location.href='/index.html';</script>";
        }
    }


    @PostMapping("/register")
    public String register(HttpServletRequest req) {
        System.out.println("register mapping");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " " + password);
        Boolean isRegister = us.handleRegister(new User(username, password));
        System.out.println(username + " " + password + " " + isRegister);
        
        if (isRegister == true) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            return "<script>alert('Successfully registered.'); window.location.href='/homepage';</script>";
        } else {
            return "<script>alert('Registration failed.'); window.location.href='/';</script>";
        }
    }
    
    @GetMapping("/homepage")
    public void homepage(HttpServletResponse res, HttpServletRequest req, HttpSession session) throws IOException {
    	if(session.getAttribute("username") != null) {
    		res.sendRedirect("homepage.html");
    	}
    	else {
    		res.sendRedirect("index.html");
    	}   
    }
    
    
    @GetMapping("/addCar")
    public void addCar(HttpServletResponse res, HttpServletRequest req, HttpSession session) throws IOException {
    	if(session.getAttribute("username") != null) {
    		res.sendRedirect("addCar.html");
    	}
    	else {
    		res.sendRedirect("index.html");
    	}   
    }
    
    @GetMapping("/cars")
    public List<Car> getCars() {
       	List<Car> cars = cs.getAllCars();
        return cars;
    }
    
    
    @PostMapping("/insertCar")
    public String insertCar(HttpServletRequest request) {
        // Retrieve data from request parameters
        String model = request.getParameter("model");
        String variant = request.getParameter("variant");
        double price = Double.parseDouble(request.getParameter("price"));
        int year = Integer.parseInt(request.getParameter("year"));
        double kilometers = Double.parseDouble(request.getParameter("kilometers"));
        int bodyCondition = Integer.parseInt(request.getParameter("bodyCondition"));
        int wheelCondition = Integer.parseInt(request.getParameter("wheelCondition"));
        int engineCondition = Integer.parseInt(request.getParameter("engineCondition"));
        int batteryCondition = Integer.parseInt(request.getParameter("batteryCondition"));
        int overallCondition = Integer.parseInt(request.getParameter("overallCondition"));

        Car car = new Car();
        car.addVariable(model, variant, price, year, kilometers, bodyCondition, wheelCondition,
            engineCondition, batteryCondition, overallCondition);

        cs.insertCar(car);
        return "<script>window.location.href='/homepage';</script>"; // Redirect to a page showing the list of cars
    }
    
    
    @PostMapping("/buyCar")
    public String buyCar(HttpServletRequest req) {
    	int id = Integer.parseInt(req.getParameter("cid"));
    	System.out.println(id + " i am called buyCAr");
    	cs.deleteById(id);
    	return "<script>window.location.href='/homepage';</script>";
    } 
    
    @GetMapping("logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();
        return "<script>window.location.href='/';</script>";
    }
    
//    @PostMapping
//    public Car addCar(@RequestBody Car car) {
//        return carRepository.save(car);
//    }

//    @GetMapping
//    public List<Car> searchCars(@RequestParam(required = false) String model,
//                                @RequestParam(required = false) String variant,
//                                @RequestParam(required = false) Double minPrice,
//                                @RequestParam(required = false) Double maxPrice,
//                                @RequestParam(required = false) Integer year,
//                                @RequestParam(required = false) Double maxKilometers) {
//        return carRepository.findByModel(model);
//    }
    
    @GetMapping("/temp")
    public String gettemp() {
    	System.out.println("clicked");
    	return "Hi i am  temp";
    }

}
