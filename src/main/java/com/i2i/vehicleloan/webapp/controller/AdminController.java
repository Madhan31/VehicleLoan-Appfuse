package com.i2i.vehicleloan.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Company;
import com.i2i.vehicleloan.model.Loan;
import com.i2i.vehicleloan.model.Payment;
import com.i2i.vehicleloan.model.User;
import com.i2i.vehicleloan.model.Vehicle;
import com.i2i.vehicleloan.model.VehicleModel;
import com.i2i.vehicleloan.service.CompanyService;
import com.i2i.vehicleloan.service.EligibilityDetailService;
import com.i2i.vehicleloan.service.LoanDetailService;
import com.i2i.vehicleloan.service.LoanService;
import com.i2i.vehicleloan.service.PaymentService;
import com.i2i.vehicleloan.service.UserAddressService;
import com.i2i.vehicleloan.service.UserManager;
import com.i2i.vehicleloan.service.VehicleModelService;
import com.i2i.vehicleloan.service.VehicleService;

@Controller
public class AdminController {

    private VehicleService vehicleService = null;    
    private CompanyService companyService = null;    
    private LoanDetailService loanDetailService = null;
    private VehicleModelService vehicleModelService = null;
    private EligibilityDetailService eligibilityDetailService = null;
    private LoanService loanService = null;
    private UserAddressService userAddressService = null;  
    private UserManager userManager = null;
    private PaymentService paymentService = null;
    
    
    @Autowired
    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }    
    
    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }    
    
    @Autowired
    public void setLoanDetailService(LoanDetailService loanDetailService) {
        this.loanDetailService = loanDetailService;
    }
    
    @Autowired
    public void setVehicleModelService(VehicleModelService vehicleModelService) {
        this.vehicleModelService = vehicleModelService;
    } 
    
    @Autowired
    public void setEligibilityDetailService(EligibilityDetailService eligibilityDetailService) {
        this.eligibilityDetailService = eligibilityDetailService;
    }
    
    @Autowired
    public void setLoanService(LoanService loanService) {
        this.loanService = loanService;
    } 
    
    @Autowired
    public void setUserAddressService(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    } 
	
    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }     
    
    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    /**
     * String adminOperation() redirects to jsp page when corresponding url is called as mapped below. 
     * @return
     *      Returns jsp file name.
     */      
    @RequestMapping("/adminOperation")
    public String adminOperation() {   
        return "adminOperation";
    }    
    
    /**
	 * String insertVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */  
    @RequestMapping("/insertVehicle")     
    public String insertVehicle(ModelMap modelMap) {
        modelMap.addAttribute("insertVehicle", new Vehicle());
        return "addVehicle";
    }
    
    /**
	 * ModelAndView addVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/addVehicle")
    public ModelAndView addVehicle(@ModelAttribute("insertVehicle") Vehicle vehicle, ModelMap modelMap) {
        try {
    	    vehicleService.addVehicle(vehicle);
    	    return new ModelAndView("addVehicle", "message", "Added successfully");
    	} catch (DatabaseException exp) {
    	    return new ModelAndView("home", "message", (exp.getMessage().toString()));
        }
    }
    
    /**
	 * ModelAndView deleteVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */   
    @RequestMapping("/deleteVehicle")
    public String deleteVehicle(ModelMap modelMap) {
        try {
            List<Vehicle> vehicles = vehicleService.retrieveVehicles();
            modelMap.addAttribute("vehicles", vehicles);            
            return "removeVehicle";
        } catch (DatabaseException exp) {
            modelMap.addAttribute("message", (exp.getMessage().toString()));
            return "vehicleOperation";
        }
    }
    
    /**
	 * ModelAndView removeVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */   
    @RequestMapping(value = "/removeVehicle", method = RequestMethod.GET)     
    public ModelAndView removeVehicle(@RequestParam("vehicleId") int vehicleId, ModelMap modelMap) {
    	try {
        	vehicleService.removeVehicle(vehicleId);  		
        	return new ModelAndView("removeVehicle", "message", "Deleted successfully");
    	} catch (DatabaseException exp) {
    	    return new ModelAndView("removeVehicle", "message", (exp.getMessage().toString()));
    	}    	
    } 
    
    /**
	 * ModelAndView retrieveAllVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */  
    @RequestMapping("/retrieveAllVehicle")     
    public String retrieveAllVehicles(ModelMap modelMap) {
        try {
            List<Vehicle> vehicles = vehicleService.retrieveVehicles();
            modelMap.addAttribute("vehicles", vehicles);
            return "retrieveAllVehicle";
    	} catch (DatabaseException exp) {
    	    modelMap.addAttribute("message", (exp.getMessage().toString()));
    	    return "vehicleOperation";
    	}
    }
    
    /**
	 * ModelAndView insertVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */   
    @RequestMapping("/insertVehicleModel")     
    public String insertVehicleModel(ModelMap modelMap) {
    	try {
            modelMap.addAttribute("insertVehicleModel", new VehicleModel());
            modelMap.addAttribute("vehicleList", vehicleService.retrieveVehicles());
            return "addVehicleModel";
    	} catch (DatabaseException exp) {
    	    modelMap.addAttribute("message", (exp.getMessage().toString()));
    	    return "vehicleModelOperation";
    	}
    }
    
    /**
	 * ModelAndView addVehicleModel() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping("/addVehicleModel")
    public ModelAndView addVehicleModel(@ModelAttribute("insertVehicleModel") VehicleModel vehicleModel, ModelMap modelMap) {
        try {
        	vehicleModelService.saveVehicleModel(vehicleModel);
        	return new ModelAndView("addVehicleModel", "message", "Added successfully");
    	} catch (DatabaseException exp) {
        	return new ModelAndView("home", "message", (exp.getMessage().toString()));
        }
    }
    
    /**
	 * ModelAndView deleteVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */   
    @RequestMapping("/deleteVehicleModel")
    public String deleteVehicleModel(ModelMap modelMap) {
        try {
            List<VehicleModel> vehicleModels = vehicleModelService.retrieveAllVehicleModel();
            modelMap.addAttribute("vehicleModels", vehicleModels);          
            return "removeVehicleModel";
        } catch (DatabaseException exp) {
            modelMap.addAttribute("message", (exp.getMessage().toString()));
            return "vehicleModelOperation";
        }
    }
    
    /**
	 * ModelAndView removeVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/removeVehicleModel", method = RequestMethod.GET)     
    public ModelAndView removeVehicleModel(@RequestParam("vehicleModelId") int vehicleModelId, ModelMap modelMap) {
        try {
        	vehicleModelService.removeVehicleModel(vehicleModelId);  		
        	return new ModelAndView("removeVehicleModel", "message", "Deleted successfully");
    	} catch (DatabaseException exp) {
        	return new ModelAndView("removeVehicleModel", "message", (exp.getMessage().toString()));
    	}    	
    } 
    
    /**
	 * ModelAndView retrieveAllVehicle() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */   
    @RequestMapping("/retrieveAllVehicleModel")     
    public String retrieveAllVehicleModel(ModelMap modelMap) {
        try {
            List<VehicleModel> vehicleModels = vehicleModelService.retrieveAllVehicleModel();
        	modelMap.addAttribute("vehicleModels", vehicleModels);
        	return "retrieveAllVehicleModel";
    	} catch (DatabaseException exp) {
        	modelMap.addAttribute("message", (exp.getMessage().toString()));
    		return "vehicleOperation";
    	}
    }	
	
	/**
	 * String admin() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */ 
	@RequestMapping("/admin")     
    public String admin(ModelMap map) {
        map.addAttribute("user", new User());
        return "admin";
    } 
	
	/**
	 * String loanDetail() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */
	@RequestMapping("/loanDetail")
    public String loanDetail(ModelMap modelMap) {
        modelMap.addAttribute("users", userManager.getUsers());
        return "loanDetail";
    }
	
	/**
	 * String contact() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */ 
	@RequestMapping("/contact") 
    public String contact() {
        return "contact";
    }
    
    /**
	 * String about() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */  
    @RequestMapping("/about") 
    public String about() {
        return "about";
    }
    
    /**
	 * String insertCompany() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */  
    @RequestMapping("/insertCompany")     
    public String insertCompany(ModelMap modelMap) {
        modelMap.addAttribute("insertCompany", new Company());
        return "addCompany";
    }
    
    /**
	 * ModelAndView addCompany() gets company details through jsp and redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */ 
    @RequestMapping("/addCompany")
    public ModelAndView addCompany(@ModelAttribute("insertCompany") Company company, ModelMap modelMap) {
        try {
        	companyService.addCompany(company);
        	return new ModelAndView("addCompany", "message", "Added successfully");
    	} catch (DatabaseException exp) {
        	return new ModelAndView("home", "message", (exp.getMessage().toString()));
        }
    }
    
    /**
	 * ModelAndView deleteCompany() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */  
    @RequestMapping("/deleteCompany")
    public String deleteCompany(ModelMap modelMap) {
        try {
            List<Company> companies = companyService.retrieveCompanies();
            modelMap.addAttribute("companies", companies);          
            return "removeCompany";
        } catch (DatabaseException exp) {
            modelMap.addAttribute("message", (exp.getMessage().toString()));
            return "vehicleModelOperation";
        }        
    }
    
    /**
	 * ModelAndView removeCompany() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */    
    @RequestMapping(value = "/removeCompany", method = RequestMethod.GET)     
    public ModelAndView removeCompany(@RequestParam("companyId") int companyId, ModelMap modelMap) {
    	try {
    		companyService.removeCompany(companyId);  		
    		return new ModelAndView("removeCompany", "message", "Deleted successfully");
    	} catch (DatabaseException exp) {
    		return new ModelAndView("removeCompany", "message", (exp.getMessage().toString()));
    	}    	
    } 
    
    /**
	 * ModelAndView retrieveAllCompany() redirects to jsp page when corresponding url is called as mapped below. 
	 * @return
	 * 		Returns jsp file name.
	 */ 
    @RequestMapping("/retrieveAllCompany")     
    public String retrieveAllCompanies(ModelMap modelMap) {
        try {
            List<Company> companies = companyService.retrieveCompanies();
        	modelMap.addAttribute("companies", companies);
        	return "retrieveAllCompany";
    	} catch (DatabaseException exp) {
        	modelMap.addAttribute("message", (exp.getMessage().toString()));
        	return "companyOperation";
    	}
    } 
    
    /**
     * ModelAndView payment() redirects to jsp page when corresponding url is called as mapped below. 
     * @return
     *      Returns jsp file name.
     */      
    @RequestMapping("/payment")
    public String payment(@RequestParam("userId") Long userId, ModelMap modelMap) {
        try {
            List<Loan> loans = loanService.retrieveLoansByUserId(userId);
            modelMap.addAttribute("loans",loans);
            modelMap.addAttribute("userId",userId);
            modelMap.addAttribute("payment", new Payment());
            return "payment";
        } catch (DatabaseException exp) {
            modelMap.addAttribute("message", (exp.getMessage().toString()));
            return "loanDetail";
        }       
    }
    
    /**
     * ModelAndView paymentConfirm() redirects to jsp page when corresponding url is called as mapped below. 
     * @return
     *      Returns jsp file name.
     */      
    @RequestMapping("/paymentConfirm") 
    public ModelAndView paymentConfirm(@ModelAttribute("payment") Payment payment, ModelMap modelMap, final HttpServletRequest request) {
        try {
            User user = userManager.getUserByUsername(request.getRemoteUser());
            payment.setUser(user);            
            modelMap.addAttribute("insert", paymentService.addPayment(payment));
            return new ModelAndView("payment", "message", "Paided Sucessfully");
        } catch (DatabaseException exp) {
            return new ModelAndView("loanDetail", "message", (exp.getMessage().toString()));
        }       
    }    
    
    /**
     * String retrievePaymentDetail() redirects to jsp page when corresponding url is called as mapped below. 
     * @return
     *      Returns jsp file name.
     */      
    @RequestMapping("/retrievePaymentDetail")
    public String retrievePaymentDetail(@RequestParam("loanId") int loanId, ModelMap modelMap, HttpSession session) {
        try {
            modelMap.addAttribute("paymentDetails", paymentService.retrievePaymentsByLoanId(loanId));           
            return "retrievePaymentDetail";
        } catch (DatabaseException exp) {
            modelMap.addAttribute("message", (exp.getMessage().toString()));
            return "retrieveLoanDetail";
        }           
    }  
    
    /**
     * String retrieveUserPaymentDetail() redirects to jsp page when corresponding url is called as mapped below. 
     * @return
     *      Returns jsp file name.
     */      
    @RequestMapping("/retrieveUserPaymentDetail")
    public String retrieveUserPaymentDetail(@RequestParam("loanId") int loanId, ModelMap modelMap, HttpSession session) {
        try {
            modelMap.addAttribute("paymentDetails", paymentService.retrievePaymentsByLoanId(loanId));           
            return "retrieveUserPaymentDetail";
        } catch (DatabaseException exp) {
            modelMap.addAttribute("message", (exp.getMessage().toString()));
            return "retrieveUserDetail";
        }           
    }    
}
