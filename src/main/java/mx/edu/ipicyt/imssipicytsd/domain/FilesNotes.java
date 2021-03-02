package mx.edu.ipicyt.imssipicytsd.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A FilesNotes.
 */
@Entity
@Table(name = "files_notes")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FilesNotes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "id_remedy_glpi", nullable = false)
    private String idRemedyGlpi;

    @NotNull
    @Column(name = "type_transaccion", nullable = false)
    private String typeTransaccion;

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
    @Column(name = "work_log_summary", nullable = false)
    private String workLogSummary;

    @NotNull
    @Column(name = "work_info_notes", nullable = false)
    private String workInfoNotes;

    @Column(name = "attachment_file_name_1")
    private String attachmentFileName1;

    @Column(name = "attachment_file_type_1")
    private String attachmentFileType1;

    @Column(name = "attachment_file_data_1")
    private String attachmentFileData1;

    @Column(name = "attachment_file_name_2")
    private String attachmentFileName2;

    @Column(name = "attachment_file_type_2")
    private String attachmentFileType2;

    @Column(name = "attachment_file_data_2")
    private String attachmentFileData2;

    @Column(name = "attachment_file_name_3")
    private String attachmentFileName3;

    @Column(name = "attachment_file_type_3")
    private String attachmentFileType3;

    @Column(name = "attachment_file_data_3")
    private String attachmentFileData3;

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

    public FilesNotes idRemedyGlpi(String idRemedyGlpi) {
        this.idRemedyGlpi = idRemedyGlpi;
        return this;
    }

    public void setIdRemedyGlpi(String idRemedyGlpi) {
        this.idRemedyGlpi = idRemedyGlpi;
    }

    public String getTypeTransaccion() {
        return typeTransaccion;
    }

    public FilesNotes typeTransaccion(String typeTransaccion) {
        this.typeTransaccion = typeTransaccion;
        return this;
    }

    public void setTypeTransaccion(String typeTransaccion) {
        this.typeTransaccion = typeTransaccion;
    }

    public String getSubTypeTransaction() {
        return subTypeTransaction;
    }

    public FilesNotes subTypeTransaction(String subTypeTransaction) {
        this.subTypeTransaction = subTypeTransaction;
        return this;
    }

    public void setSubTypeTransaction(String subTypeTransaction) {
        this.subTypeTransaction = subTypeTransaction;
    }

    public String getIdReferenciaCliente() {
        return idReferenciaCliente;
    }

    public FilesNotes idReferenciaCliente(String idReferenciaCliente) {
        this.idReferenciaCliente = idReferenciaCliente;
        return this;
    }

    public void setIdReferenciaCliente(String idReferenciaCliente) {
        this.idReferenciaCliente = idReferenciaCliente;
    }

    public String getCompany() {
        return company;
    }

    public FilesNotes company(String company) {
        this.company = company;
        return this;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorkLogSummary() {
        return workLogSummary;
    }

    public FilesNotes workLogSummary(String workLogSummary) {
        this.workLogSummary = workLogSummary;
        return this;
    }

    public void setWorkLogSummary(String workLogSummary) {
        this.workLogSummary = workLogSummary;
    }

    public String getWorkInfoNotes() {
        return workInfoNotes;
    }

    public FilesNotes workInfoNotes(String workInfoNotes) {
        this.workInfoNotes = workInfoNotes;
        return this;
    }

    public void setWorkInfoNotes(String workInfoNotes) {
        this.workInfoNotes = workInfoNotes;
    }

    public String getAttachmentFileName1() {
        return attachmentFileName1;
    }

    public FilesNotes attachmentFileName1(String attachmentFileName1) {
        this.attachmentFileName1 = attachmentFileName1;
        return this;
    }

    public void setAttachmentFileName1(String attachmentFileName1) {
        this.attachmentFileName1 = attachmentFileName1;
    }

    public String getAttachmentFileType1() {
        return attachmentFileType1;
    }

    public FilesNotes attachmentFileType1(String attachmentFileType1) {
        this.attachmentFileType1 = attachmentFileType1;
        return this;
    }

    public void setAttachmentFileType1(String attachmentFileType1) {
        this.attachmentFileType1 = attachmentFileType1;
    }

    public String getAttachmentFileData1() {
        return attachmentFileData1;
    }

    public FilesNotes attachmentFileData1(String attachmentFileData1) {
        this.attachmentFileData1 = attachmentFileData1;
        return this;
    }

    public void setAttachmentFileData1(String attachmentFileData1) {
        this.attachmentFileData1 = attachmentFileData1;
    }

    public String getAttachmentFileName2() {
        return attachmentFileName2;
    }

    public FilesNotes attachmentFileName2(String attachmentFileName2) {
        this.attachmentFileName2 = attachmentFileName2;
        return this;
    }

    public void setAttachmentFileName2(String attachmentFileName2) {
        this.attachmentFileName2 = attachmentFileName2;
    }

    public String getAttachmentFileType2() {
        return attachmentFileType2;
    }

    public FilesNotes attachmentFileType2(String attachmentFileType2) {
        this.attachmentFileType2 = attachmentFileType2;
        return this;
    }

    public void setAttachmentFileType2(String attachmentFileType2) {
        this.attachmentFileType2 = attachmentFileType2;
    }

    public String getAttachmentFileData2() {
        return attachmentFileData2;
    }

    public FilesNotes attachmentFileData2(String attachmentFileData2) {
        this.attachmentFileData2 = attachmentFileData2;
        return this;
    }

    public void setAttachmentFileData2(String attachmentFileData2) {
        this.attachmentFileData2 = attachmentFileData2;
    }

    public String getAttachmentFileName3() {
        return attachmentFileName3;
    }

    public FilesNotes attachmentFileName3(String attachmentFileName3) {
        this.attachmentFileName3 = attachmentFileName3;
        return this;
    }

    public void setAttachmentFileName3(String attachmentFileName3) {
        this.attachmentFileName3 = attachmentFileName3;
    }

    public String getAttachmentFileType3() {
        return attachmentFileType3;
    }

    public FilesNotes attachmentFileType3(String attachmentFileType3) {
        this.attachmentFileType3 = attachmentFileType3;
        return this;
    }

    public void setAttachmentFileType3(String attachmentFileType3) {
        this.attachmentFileType3 = attachmentFileType3;
    }

    public String getAttachmentFileData3() {
        return attachmentFileData3;
    }

    public FilesNotes attachmentFileData3(String attachmentFileData3) {
        this.attachmentFileData3 = attachmentFileData3;
        return this;
    }

    public void setAttachmentFileData3(String attachmentFileData3) {
        this.attachmentFileData3 = attachmentFileData3;
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
        FilesNotes filesNotes = (FilesNotes) o;
        if (filesNotes.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), filesNotes.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FilesNotes{" +
            "id=" + getId() +
            ", idRemedyGlpi='" + getIdRemedyGlpi() + "'" +
            ", typeTransaccion='" + getTypeTransaccion() + "'" +
            ", subTypeTransaction='" + getSubTypeTransaction() + "'" +
            ", idReferenciaCliente='" + getIdReferenciaCliente() + "'" +
            ", company='" + getCompany() + "'" +
            ", workLogSummary='" + getWorkLogSummary() + "'" +
            ", workInfoNotes='" + getWorkInfoNotes() + "'" +
            ", attachmentFileName1='" + getAttachmentFileName1() + "'" +
            ", attachmentFileType1='" + getAttachmentFileType1() + "'" +
            ", attachmentFileData1='" + getAttachmentFileData1() + "'" +
            ", attachmentFileName2='" + getAttachmentFileName2() + "'" +
            ", attachmentFileType2='" + getAttachmentFileType2() + "'" +
            ", attachmentFileData2='" + getAttachmentFileData2() + "'" +
            ", attachmentFileName3='" + getAttachmentFileName3() + "'" +
            ", attachmentFileType3='" + getAttachmentFileType3() + "'" +
            ", attachmentFileData3='" + getAttachmentFileData3() + "'" +
            "}";
    }
}
