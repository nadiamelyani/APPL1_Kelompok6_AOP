package model;

import org.springframework.data.annotation.Id;

public class Pelajaran {
	
	@Id
	private String id;
	
	private String nama_pelajaran;
	private int jam_pelajaran;
	
	public Pelajaran() {
		
	}
	
	public Pelajaran(String id, String nama, int jam) {
		this.id = id;
		this.nama_pelajaran = nama;
		this.jam_pelajaran = jam;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama_pelajaran() {
		return nama_pelajaran;
	}

	public void setNama_pelajaran(String nama_pelajaran) {
		this.nama_pelajaran = nama_pelajaran;
	}

	public int getJam_pelajaran() {
		return jam_pelajaran;
	}

	public void setJam_pelajaran(int jam_pelajaran) {
		this.jam_pelajaran = jam_pelajaran;
	}
	
	@Override
	public String toString() {
		return id+"::"+nama_pelajaran+"::"+jam_pelajaran;
	}
}
