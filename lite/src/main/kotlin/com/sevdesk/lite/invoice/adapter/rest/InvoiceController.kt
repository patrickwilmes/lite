package com.sevdesk.lite.invoice.adapter.rest

import com.sevdesk.lite.failure.Failure
import com.sevdesk.lite.failure.transformToResponseEntity
import com.sevdesk.lite.invoice.adapter.persistence.InvoiceRepository
import com.sevdesk.lite.invoice.service.InvoiceService
import com.sevdesk.lite.invoice.Invoice
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/invoices")
@Validated
class InvoiceController(
    private val invoiceService: InvoiceService
) {

    @GetMapping
    fun getAllInvoices(
        page: Pageable = Pageable.unpaged()
    ): ResponseEntity<List<Invoice>> =
        invoiceService.getAllInvoices()
            .fold({
                transformToResponseEntity(it, logger)
            }) {
                ResponseEntity.ok(it)
            }

    @GetMapping("/{id}")
    fun getInvoice(
        @PathVariable("id") id: Long
    ): ResponseEntity<Invoice> =
        /*
        ArrowKT uses suspend functions to model monads internally. Due to this,
        you're forced to use suspension functions to of course. As it would be
        an overkill for this task to switch the whole project to spring webflux,
        we are going with runBlocking here, which opens up a coroutine scope for
        us to call the suspend function.
         */
        runBlocking {
            invoiceService.getInvoice(id)
                .fold({
                    transformToResponseEntity(it, logger)
                }) {
                    ResponseEntity.ok(it)
                }
        }

    /*
    This should not return 200 OK in case the invoice is created. According to
    rest we should return 204 CREATED with the location header set to the
    endpoint of the resource.
     */
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun addInvoice(
        @RequestBody invoice: Invoice
    ): ResponseEntity<Invoice> =
        invoiceService.saveInvoice(invoice)
            .fold({
                transformToResponseEntity(it, logger)
            }) {
                ResponseEntity.ok(it)
            }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteInvoice(
        @PathVariable("id") id: Long
    ): ResponseEntity<Any> =
        invoiceService.deleteInvoice(id)
            .fold({
                transformToResponseEntity(it, logger)
            }) {
                ResponseEntity.noContent().build()
            }

    companion object {
        private val logger = LoggerFactory.getLogger(InvoiceController::class.java)
    }
}
