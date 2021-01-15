package mx.edu.ipicyt.imssipicytsd.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A Ticket.
 */
@Entity
@Table(name = "ticket")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "id_remedy_glpi", nullable = false)
    private String idRemedyGlpi;

    @NotNull
    @Column(name = "sub_type_transaction", nullable = false)
    private String subTypeTransaction;

    @NotNull
    @Column(name = "id_referencia_cliente", nullable = false)
    private String idReferenciaCliente;

    @NotNull
    @Column(name = "company", nullable = false)
    private String company;

    @NotNull
    @Column(name = "prod_cat_01", nullable = false)
    private String prodCat01;

    @NotNull
    @Column(name = "prod_cat_02", nullable = false)
    private String prodCat02;

    @NotNull
    @Column(name = "prod_cat_03", nullable = false)
    private String prodCat03;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @NotNull
    @Column(name = "cat_op_01", nullable = false)
    private String catOp01;

    @NotNull
    @Column(name = "cat_op_02", nullable = false)
    private String catOp02;

    @NotNull
    @Column(name = "cat_op_03", nullable = false)
    private String catOp03;

    @NotNull
    @Column(name = "glpi_tickets_requesttypes_id", nullable = false)
    private String glpiTicketsRequesttypesId;

    @NotNull
    @Column(name = "contact_type", nullable = false)
    private String contactType;

    @NotNull
    @Column(name = "impact", nullable = false)
    private String impact;

    @NotNull
    @Column(name = "urgency", nullable = false)
    private String urgency;

    @NotNull
    @Column(name = "glpi_tickets_name", nullable = false)
    private String glpiTicketsName;

    @Column(name = "glpi_tickets_content")
    private String glpiTicketsContent;

    @Column(name = "notes")
    private String notes;

    @NotNull
    @Column(name = "actual_sys_date", nullable = false)
    private Instant actualSysDate;

    @NotNull
    @Column(name = "caller", nullable = false)
    private String caller;

    @NotNull
    @Column(name = "caller_email", nullable = false)
    private String callerEmail;

    @NotNull
    @Column(name = "caller_phone", nullable = false)
    private String callerPhone;

    @Column(name = "type_transaccion")
    private String typeTransaccion;

    @Column(name = "id_glpi")
    private String idGlpi;

    @Column(name = "idtype_req_sol")
    private String idtypeReqSol;

    @Column(name = "id_priority")
    private String idPriority;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdRemedyGlpi() {
        return idRemedyGlpi;
    }

    public Ticket idRemedyGlpi(String idRemedyGlpi) {
        this.idRemedyGlpi = idRemedyGlpi;
        return this;
    }

    public void setIdRemedyGlpi(String idRemedyGlpi) {
        this.idRemedyGlpi = idRemedyGlpi;
    }

    public String getSubTypeTransaction() {
        return subTypeTransaction;
    }

    public Ticket subTypeTransaction(String subTypeTransaction) {
        this.subTypeTransaction = subTypeTransaction;
        return this;
    }

    public void setSubTypeTransaction(String subTypeTransaction) {
        this.subTypeTransaction = subTypeTransaction;
    }

    public String getIdReferenciaCliente() {
        return idReferenciaCliente;
    }

    public Ticket idReferenciaCliente(String idReferenciaCliente) {
        this.idReferenciaCliente = idReferenciaCliente;
        return this;
    }

    public void setIdReferenciaCliente(String idReferenciaCliente) {
        this.idReferenciaCliente = idReferenciaCliente;
    }

    public String getCompany() {
        return company;
    }

    public Ticket company(String company) {
        this.company = company;
        return this;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProdCat01() {
        return prodCat01;
    }

    public Ticket prodCat01(String prodCat01) {
        this.prodCat01 = prodCat01;
        return this;
    }

    public void setProdCat01(String prodCat01) {
        this.prodCat01 = prodCat01;
    }

    public String getProdCat02() {
        return prodCat02;
    }

    public Ticket prodCat02(String prodCat02) {
        this.prodCat02 = prodCat02;
        return this;
    }

    public void setProdCat02(String prodCat02) {
        this.prodCat02 = prodCat02;
    }

    public String getProdCat03() {
        return prodCat03;
    }

    public Ticket prodCat03(String prodCat03) {
        this.prodCat03 = prodCat03;
        return this;
    }

    public void setProdCat03(String prodCat03) {
        this.prodCat03 = prodCat03;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public Ticket nombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
        return this;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCatOp01() {
        return catOp01;
    }

    public Ticket catOp01(String catOp01) {
        this.catOp01 = catOp01;
        return this;
    }

    public void setCatOp01(String catOp01) {
        this.catOp01 = catOp01;
    }

    public String getCatOp02() {
        return catOp02;
    }

    public Ticket catOp02(String catOp02) {
        this.catOp02 = catOp02;
        return this;
    }

    public void setCatOp02(String catOp02) {
        this.catOp02 = catOp02;
    }

    public String getCatOp03() {
        return catOp03;
    }

    public Ticket catOp03(String catOp03) {
        this.catOp03 = catOp03;
        return this;
    }

    public void setCatOp03(String catOp03) {
        this.catOp03 = catOp03;
    }

    public String getGlpiTicketsRequesttypesId() {
        return glpiTicketsRequesttypesId;
    }

    public Ticket glpiTicketsRequesttypesId(String glpiTicketsRequesttypesId) {
        this.glpiTicketsRequesttypesId = glpiTicketsRequesttypesId;
        return this;
    }

    public void setGlpiTicketsRequesttypesId(String glpiTicketsRequesttypesId) {
        this.glpiTicketsRequesttypesId = glpiTicketsRequesttypesId;
    }

    public String getContactType() {
        return contactType;
    }

    public Ticket contactType(String contactType) {
        this.contactType = contactType;
        return this;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getImpact() {
        return impact;
    }

    public Ticket impact(String impact) {
        this.impact = impact;
        return this;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getUrgency() {
        return urgency;
    }

    public Ticket urgency(String urgency) {
        this.urgency = urgency;
        return this;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getGlpiTicketsName() {
        return glpiTicketsName;
    }

    public Ticket glpiTicketsName(String glpiTicketsName) {
        this.glpiTicketsName = glpiTicketsName;
        return this;
    }

    public void setGlpiTicketsName(String glpiTicketsName) {
        this.glpiTicketsName = glpiTicketsName;
    }

    public String getGlpiTicketsContent() {
        return glpiTicketsContent;
    }

    public Ticket glpiTicketsContent(String glpiTicketsContent) {
        this.glpiTicketsContent = glpiTicketsContent;
        return this;
    }

    public void setGlpiTicketsContent(String glpiTicketsContent) {
        this.glpiTicketsContent = glpiTicketsContent;
    }

    public String getNotes() {
        return notes;
    }

    public Ticket notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Instant getActualSysDate() {
        return actualSysDate;
    }

    public Ticket actualSysDate(Instant actualSysDate) {
        this.actualSysDate = actualSysDate;
        return this;
    }

    public void setActualSysDate(Instant actualSysDate) {
        this.actualSysDate = actualSysDate;
    }

    public String getCaller() {
        return caller;
    }

    public Ticket caller(String caller) {
        this.caller = caller;
        return this;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getCallerEmail() {
        return callerEmail;
    }

    public Ticket callerEmail(String callerEmail) {
        this.callerEmail = callerEmail;
        return this;
    }

    public void setCallerEmail(String callerEmail) {
        this.callerEmail = callerEmail;
    }

    public String getCallerPhone() {
        return callerPhone;
    }

    public Ticket callerPhone(String callerPhone) {
        this.callerPhone = callerPhone;
        return this;
    }

    public void setCallerPhone(String callerPhone) {
        this.callerPhone = callerPhone;
    }

    public String getTypeTransaccion() {
        return typeTransaccion;
    }

    public Ticket typeTransaccion(String typeTransaccion) {
        this.typeTransaccion = typeTransaccion;
        return this;
    }

    public void setTypeTransaccion(String typeTransaccion) {
        this.typeTransaccion = typeTransaccion;
    }

    public String getIdGlpi() {
        return idGlpi;
    }

    public Ticket idGlpi(String idGlpi) {
        this.idGlpi = idGlpi;
        return this;
    }

    public void setIdGlpi(String idGlpi) {
        this.idGlpi = idGlpi;
    }

    public String getIdtypeReqSol() {
        return idtypeReqSol;
    }

    public Ticket idtypeReqSol(String idtypeReqSol) {
        this.idtypeReqSol = idtypeReqSol;
        return this;
    }

    public void setIdtypeReqSol(String idtypeReqSol) {
        this.idtypeReqSol = idtypeReqSol;
    }

    public String getIdPriority() {
        return idPriority;
    }

    public Ticket idPriority(String idPriority) {
        this.idPriority = idPriority;
        return this;
    }

    public void setIdPriority(String idPriority) {
        this.idPriority = idPriority;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        if (ticket.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ticket.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Ticket{" +
            "id=" + getId() +
            ", idRemedyGlpi='" + getIdRemedyGlpi() + "'" +
            ", subTypeTransaction='" + getSubTypeTransaction() + "'" +
            ", idReferenciaCliente='" + getIdReferenciaCliente() + "'" +
            ", company='" + getCompany() + "'" +
            ", prodCat01='" + getProdCat01() + "'" +
            ", prodCat02='" + getProdCat02() + "'" +
            ", prodCat03='" + getProdCat03() + "'" +
            ", nombreProducto='" + getNombreProducto() + "'" +
            ", catOp01='" + getCatOp01() + "'" +
            ", catOp02='" + getCatOp02() + "'" +
            ", catOp03='" + getCatOp03() + "'" +
            ", glpiTicketsRequesttypesId='" + getGlpiTicketsRequesttypesId() + "'" +
            ", contactType='" + getContactType() + "'" +
            ", impact='" + getImpact() + "'" +
            ", urgency='" + getUrgency() + "'" +
            ", glpiTicketsName='" + getGlpiTicketsName() + "'" +
            ", glpiTicketsContent='" + getGlpiTicketsContent() + "'" +
            ", notes='" + getNotes() + "'" +
            ", actualSysDate='" + getActualSysDate() + "'" +
            ", caller='" + getCaller() + "'" +
            ", callerEmail='" + getCallerEmail() + "'" +
            ", callerPhone='" + getCallerPhone() + "'" +
            ", typeTransaccion='" + getTypeTransaccion() + "'" +
            ", idGlpi='" + getIdGlpi() + "'" +
            ", idtypeReqSol='" + getIdtypeReqSol() + "'" +
            ", idPriority='" + getIdPriority() + "'" +
            "}";
    }
}
