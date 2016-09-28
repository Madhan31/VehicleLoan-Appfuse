package com.i2i.vehicleloan.webapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.i2i.vehicleloan.Constants;
import com.i2i.vehicleloan.dao.SearchException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.EligibilityDetail;
import com.i2i.vehicleloan.model.Loan;
import com.i2i.vehicleloan.model.LoanDetail;
import com.i2i.vehicleloan.model.UserAddress;
import com.i2i.vehicleloan.model.VehicleModel;
import com.i2i.vehicleloan.service.CompanyService;
import com.i2i.vehicleloan.service.EligibilityDetailService;
import com.i2i.vehicleloan.service.LoanDetailService;
import com.i2i.vehicleloan.service.LoanService;
import com.i2i.vehicleloan.service.UserAddressService;
import com.i2i.vehicleloan.service.UserManager;
import com.i2i.vehicleloan.service.VehicleModelService;
import com.i2i.vehicleloan.service.VehicleService;

/**
 * <p>
 * LoanController class which has methods for adding, removing, etc., loan details and payment detail for an logged user.
 * This class gets input like user name, contact, etc., from user through jsp page and calls corresponding loan service methods to add or update particular user details. 
 * And it calls jsp pages for success or failure messages and also for exceptions.
 * </p>
 * 
 * @author Madhan
 * 
 * @since 2016-09-06
 */
@Controller
public class UserController {
    
    private UserManager userManager = null;    
    private VehicleService vehicleService = null;    
    private CompanyService companyService = null;    
    private LoanDetailService loanDetailService = null;
    private VehicleModelService vehicleModelService = null;
    private EligibilityDetailService eligibilityDetailService = null;
    private LoanService loanService = null;
    private UserAddressService userAddressService = null;

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }    
    
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
    
    @RequestMapping("/admin/users*")
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query) throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(Constants.USER_LIST, userManager.search(query));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(userManager.getUsers());
        }
        return new ModelAndView("admin/userList", model.asMap());
    }
    
    /**
     * String userOperation() redirects to jsp page when corresponding url is called as mapped below
     * @return
     *     Returns jsp file name.
     */
    @RequestMapping("/userOperation")
    public String userOperation() {   
        return "userOperation";
    }     

    /**
     * String eligibilityDetail() redirects to jsp page when corresponding url is called as mapped below. 
     * @return
     *         Returns jsp file name.
     */        
    @RequestMapping("/homePage")     
    public String eligibilityDetail(ModelMap modelMap, HttpSession session) {
        try {
            modelMap.addAttribute("eligibilityDetail", new EligibilityDetail());
            modelMap.addAttribute("vehicleList", vehicleService.retrieveVehicles());
            modelMap.addAttribute("companyList", companyService.retrieveCompanies());            
            //modelMap.addAttribute("loanDetail", loanDetailService.retrieveLoanDetailByUserId((int)session.getAttribute("userId")));
            return "homePage";
        } catch (DatabaseException exp) {
            modelMap.addAttribute("message", (exp.getMessage().toString()));
            return "homePage";
        } 
    }    
    
    /**
     * ModelAndView vehicleModelView() gets vehicle id through jsp and redirects to jsp page when corresponding url is called as mapped below. 
     * @return
     *         Returns jsp file name.
     */    
    @RequestMapping(value = "/vehicleModelView", method = RequestMethod.GET)     
    public String vehicleModelView(@RequestParam("vehicleId") int vehicleId, ModelMap modelMap) {
        try {
            modelMap.addAttribute("vehicleModelList", vehicleModelService.getVehicleModelsByVehicleId(vehicleId));
            return "vehicleModelView";
        } catch (DatabaseException exp) {
            modelMap.addAttribute("message", (exp.getMessage().toString()));
            return "homePage";
        }
    }
    
    /**
     * ModelAndView vehicleModelPrice() gets vehicle Model Id through jsp and redirects to jsp page when corresponding url is called as mapped below. 
     * @return
     *         Returns jsp file name.
     */    
    @RequestMapping(value = "/vehicleModelPrice", method = RequestMethod.GET)     
    public String vehicleModelPrice(@RequestParam("vehicleModelId") int vehicleModelId, ModelMap modelMap) {
        try {
            modelMap.addAttribute("vehicleModel", vehicleModelService.getVehicleModelById(vehicleModelId));
            return "vehicleModelPrice";
        } catch (DatabaseException exp) {
            modelMap.addAttribute("message", exp.getMessage());
            return "homePage";
        }
    }    
    
    /**
     * ModelAndView addEligibilityDetail method gets eligibility details from user and transfer to corresponds jsp file.
     * @param eligibilityDetail
     *      Contains eligibility detail of an user.
     * @param modelMap
     *      It's like a hashmap used to store key and value.
     * @return
     *      Returns to jsp file to display the output.
     */
    @RequestMapping(value = "/addeligibilitydetail", method = RequestMethod.GET)
    public ModelAndView addEligibilityDetail(@ModelAttribute("eligibilityDetail") EligibilityDetail eligibilityDetail, BindingResult bindingResult, ModelMap modelMap) {
        try {
            VehicleModel vechicleModel = vehicleModelService.getVehicleModelById(eligibilityDetail.getVehicleModel().getVehicleModelId()); 
            if (eligibilityDetailService.addEligibilityDetail(eligibilityDetail)) {
                modelMap.addAttribute("eligibilityDetailId", eligibilityDetail.getId());
                modelMap.addAttribute("loan", new Loan());
                return new ModelAndView("loan", "loanamount", loanService.calculateLoanAmount(eligibilityDetail, vechicleModel));
            } else {
                return new ModelAndView("homePage", "message", "Data not inserted...");
            }            
        } catch (DatabaseException exp) {
            return new ModelAndView("homePage", "message", exp.getMessage());           
        }
    }  
    
    /**
     * String emi() gets loanperiod and loan amount through jsp and redirects to jsp page when corresponding url is called as mapped below. 
     * @return
     *      Returns jsp file name.
     */    
    @RequestMapping(value = "/emi", method = RequestMethod.GET)     
    public String emi(@RequestParam("loanPeriod") int loanPeriod,@RequestParam("loanAmount") int loanAmount, ModelMap modelMap) {
        modelMap.addAttribute("emi", loanService.getEmiDetails(loanPeriod, loanAmount));
        modelMap.addAttribute("processingFees", loanService.getProcessingFees(loanPeriod, loanAmount));
        modelMap.addAttribute("documentationCharges", loanService.getDocumentationCharges(loanPeriod, loanAmount));
        return "emi";
    }     
    
    /**
     * ModelAndView addLoanDetail method gets loan details from user and transfer to corresponds jsp file.
     * @param loan
     *      It contains loan details of an user.
     * @param modelMap
     *      It's like a hashmap used to store key and value.
     * @return
     *      Returns to the jsp file for output.
     */
    @RequestMapping(value = "/addloandetail", method = RequestMethod.GET)
    public String addLoanDetail(@ModelAttribute("loan") Loan loan, BindingResult bindingResult, ModelMap modelMap) {
        try {
            loanService.addLoan(loan);
            loanDetailService.addLoanDetail(new LoanDetail(loan.getLoanAmount(), loan.getLoanPeriod(), loan.getUser()));
            modelMap.addAttribute("userAddress", new UserAddress()); 
            return "address";
        } catch (DatabaseException exp) {
            modelMap.addAttribute("message", exp.getMessage());
            return "loan";
        }
    }   
    
    /**
     * ModelAndView addAddress method gets address from user and transfer to corresponds jsp file.
     * @param address
     *      It contains user address detail.
     * @param modelMap
     *      It's like a hashmap used to store key and value.
     * @return
     *      Returns to jsp file.
     */
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ModelAndView addAddress(@ModelAttribute("userAddress") UserAddress userAddress, BindingResult bindingResult, ModelMap modelMap) {
        try {
            userAddressService.addAddress(userAddress);
            return new ModelAndView("address", "message", "Loan applied successfully we will contact you soon");
        } catch (DatabaseException exp) {
            return new ModelAndView("address", "message", exp.getMessage());
        }
    }    
}
