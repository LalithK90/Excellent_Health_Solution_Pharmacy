package lk.excellent.pharamacy_management.asset.process.finance.dao;

import lk.excellent.pharamacy_management.asset.process.finance.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceDao extends JpaRepository<Invoice, Integer> {
    List<Invoice> findByInvoicedAtBetween(LocalDate createdAt, LocalDate createdAt2);

    Invoice findFirstByOrderByIdDesc();
}
