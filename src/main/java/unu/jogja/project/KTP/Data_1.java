/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unu.jogja.project.KTP;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Data_1.findAll", query = "SELECT d FROM Data_1 d"),
    @NamedQuery(name = "Data_1.findById", query = "SELECT d FROM Data_1 d WHERE d.dataPK.id = :id"),
    @NamedQuery(name = "Data_1.findByNomorktp", query = "SELECT d FROM Data_1 d WHERE d.dataPK.nomorktp = :nomorktp"),
    @NamedQuery(name = "Data_1.findByNama", query = "SELECT d FROM Data_1 d WHERE d.nama = :nama"),
    @NamedQuery(name = "Data_1.findByTglahir", query = "SELECT d FROM Data_1 d WHERE d.tglahir = :tglahir"),
    @NamedQuery(name = "Data_1.findByJeniskelamin", query = "SELECT d FROM Data_1 d WHERE d.jeniskelamin = :jeniskelamin"),
    @NamedQuery(name = "Data_1.findByAlamat", query = "SELECT d FROM Data_1 d WHERE d.alamat = :alamat"),
    @NamedQuery(name = "Data_1.findByAgama", query = "SELECT d FROM Data_1 d WHERE d.agama = :agama"),
    @NamedQuery(name = "Data_1.findByStatus", query = "SELECT d FROM Data_1 d WHERE d.status = :status"),
    @NamedQuery(name = "Data_1.findByPekerjaan", query = "SELECT d FROM Data_1 d WHERE d.pekerjaan = :pekerjaan"),
    @NamedQuery(name = "Data_1.findByWarganegara", query = "SELECT d FROM Data_1 d WHERE d.warganegara = :warganegara"),
    @NamedQuery(name = "Data_1.findByBerlakuhiingga", query = "SELECT d FROM Data_1 d WHERE d.berlakuhiingga = :berlakuhiingga")})
public class Data_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DataPK dataPK;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "tglahir")
    @Temporal(TemporalType.DATE)
    private Date tglahir;
    @Basic(optional = false)
    @Column(name = "jeniskelamin")
    private String jeniskelamin;
    @Basic(optional = false)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @Column(name = "agama")
    private String agama;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Column(name = "pekerjaan")
    private String pekerjaan;
    @Basic(optional = false)
    @Column(name = "warganegara")
    private String warganegara;
    @Basic(optional = false)
    @Column(name = "berlakuhiingga")
    private String berlakuhiingga;
    @Lob
    @Column(name = "foto")
    private byte[] foto;

    public Data_1() {
    }

    public Data_1(DataPK dataPK) {
        this.dataPK = dataPK;
    }

    public Data_1(DataPK dataPK, String nama, Date tglahir, String jeniskelamin, String alamat, String agama, String status, String warganegara, String berlakuhiingga) {
        this.dataPK = dataPK;
        this.nama = nama;
        this.tglahir = tglahir;
        this.jeniskelamin = jeniskelamin;
        this.alamat = alamat;
        this.agama = agama;
        this.status = status;
        this.warganegara = warganegara;
        this.berlakuhiingga = berlakuhiingga;
    }

    public Data_1(int id, String nomorktp) {
        this.dataPK = new DataPK(id, nomorktp);
    }

    public DataPK getDataPK() {
        return dataPK;
    }

    public void setDataPK(DataPK dataPK) {
        this.dataPK = dataPK;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTglahir() {
        return tglahir;
    }

    public void setTglahir(Date tglahir) {
        this.tglahir = tglahir;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getWarganegara() {
        return warganegara;
    }

    public void setWarganegara(String warganegara) {
        this.warganegara = warganegara;
    }

    public String getBerlakuhiingga() {
        return berlakuhiingga;
    }

    public void setBerlakuhiingga(String berlakuhiingga) {
        this.berlakuhiingga = berlakuhiingga;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataPK != null ? dataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Data_1)) {
            return false;
        }
        Data_1 other = (Data_1) object;
        if ((this.dataPK == null && other.dataPK != null) || (this.dataPK != null && !this.dataPK.equals(other.dataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unu.jogja.project.KTP.Data_1[ dataPK=" + dataPK + " ]";
    }
    
}
