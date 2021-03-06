package lk.excellent.pharamacy_management.asset.process.reports;

import lk.excellent.pharamacy_management.asset.item.entity.Item;
import lk.excellent.pharamacy_management.asset.item.service.ItemService;
import lk.excellent.pharamacy_management.asset.process.finance.service.InvoiceService;
import lk.excellent.pharamacy_management.asset.process.generalLedger.service.LedgerService;
import lk.excellent.pharamacy_management.asset.process.goodReceivingManagement.service.GoodReceivingManagementService;
import lk.excellent.pharamacy_management.asset.process.purchaseOrder.entity.PurchaseOrder;
import lk.excellent.pharamacy_management.asset.process.purchaseOrder.service.PurchaseOrderService;
import lk.excellent.pharamacy_management.asset.process.reports.entityHelp.ReportHelp;
import lk.excellent.pharamacy_management.security.entity.User;
import lk.excellent.pharamacy_management.security.service.UserService;
import lk.excellent.pharamacy_management.util.service.DateTimeAgeService;
import lk.excellent.pharamacy_management.util.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/itemReport")
public class ItemReportController {
    private final InvoiceService invoiceService;
    private final PurchaseOrderService purchaseOrderService;
    private final LedgerService ledgerService;
    private final UserService userService;
    private final GoodReceivingManagementService goodReceivingManagementService;
    private final ItemService itemService;
    private final DateTimeAgeService dateTimeAgeService;
    private final OperatorService operatorService;

    @Autowired
    public ItemReportController(InvoiceService invoiceService, PurchaseOrderService purchaseOrderService, LedgerService ledgerService, UserService userService, GoodReceivingManagementService goodReceivingManagementService, ItemService itemService, DateTimeAgeService dateTimeAgeService, OperatorService operatorService) {
        this.invoiceService = invoiceService;
        this.purchaseOrderService = purchaseOrderService;
        this.ledgerService = ledgerService;
        this.userService = userService;
        this.goodReceivingManagementService = goodReceivingManagementService;
        this.itemService = itemService;
        this.dateTimeAgeService = dateTimeAgeService;
        this.operatorService = operatorService;
    }

    @GetMapping("/form")
    public String dailyReport(Model model){
        model.addAttribute("givenDate", dateTimeAgeService.getCurrentDate().toString());
        User user = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("dateObject", new ReportHelp());
        model.addAttribute("date", dateTimeAgeService.getCurrentDateTime());
        model.addAttribute("user", user.getEmployee().getTitle().getTitle() + " " + user.getEmployee().getName());
        List<Item> items = itemService.findByCreatedAtBetween(dateTimeAgeService.getCurrentDate(), dateTimeAgeService.getCurrentDate());
        model.addAttribute("items", items);
        return "summary/ItemSummary";
    }

    @PostMapping("/search")
    public String rangeReport(@Valid @ModelAttribute ReportHelp reportHelp, Model model){
        User user = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());

        model.addAttribute("dateObject", new ReportHelp());
        model.addAttribute("date", dateTimeAgeService.getCurrentDateTime());
        model.addAttribute("user", user.getEmployee().getTitle().getTitle() + " " + user.getEmployee().getName());

        model.addAttribute("givenDate", "FROM : " + reportHelp.getStartDate().toString() + "  TO : " + reportHelp.getEndDate().toString());
        List<Item> items = itemService.findByCreatedAtBetween(reportHelp.getStartDate(),reportHelp.getEndDate());
        model.addAttribute("items", items);
        return "summary/ItemSummary";
    }

    @GetMapping("/purchaseOrderForm")
    public String purchaseOrderDailyReport(Model model){
        model.addAttribute("givenDate", dateTimeAgeService.getCurrentDate().toString());
        User user = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("dateObject", new ReportHelp());
        model.addAttribute("date", dateTimeAgeService.getCurrentDateTime());
        model.addAttribute("user", user.getEmployee().getTitle().getTitle() + " " + user.getEmployee().getName());
        List<PurchaseOrder> purchaseOrders = purchaseOrderService.findByCreatedAtBetween(dateTimeAgeService.getCurrentDate(), dateTimeAgeService.getCurrentDate());
        model.addAttribute("purchaseOrders", purchaseOrders);
        return "summary/POSummary";
    }

    @PostMapping("/POrange")
    public String purchaseOrderRangeReport(@Valid @ModelAttribute ReportHelp reportHelp, Model model){
        User user = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());

        model.addAttribute("dateObject", new ReportHelp());
        model.addAttribute("date", dateTimeAgeService.getCurrentDateTime());
        model.addAttribute("user", user.getEmployee().getTitle().getTitle() + " " + user.getEmployee().getName());

        model.addAttribute("givenDate", "FROM : " + reportHelp.getStartDate().toString() + "  TO : " + reportHelp.getEndDate().toString());
        List<PurchaseOrder> purchaseOrders = purchaseOrderService.findByCreatedAtBetween(reportHelp.getStartDate(), reportHelp.getEndDate());
        model.addAttribute("purchaseOrders", purchaseOrders);
        return "summary/POSummary";
    }
}
