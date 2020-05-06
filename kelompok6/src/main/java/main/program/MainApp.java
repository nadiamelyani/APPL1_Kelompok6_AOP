package main.program;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.aspectj.weaver.Iterators;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Pelajaran;

public class MainApp {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
		
		Operation pelajaranOpr = ctx.getBean("pelajaran", Operation.class);
		Pelajaran pelajaran=null;
		int user_choice = 0;
		while(user_choice != 5) {
			user_choice = menu();
			  switch(user_choice) {
			  case 1: System.out.println("Insert Data");
			  		pelajaran = insert_new();
					pelajaranOpr.create(pelajaran);
					System.out.println("Pelajaran baru telah tersimpan");
			  break;
			  case 2: System.out.println("Retrieve Data");
			  /* Logika program ini belum bisa bekerja
			  		ArrayList<Pelajaran> listData = new ArrayList();
			  		Iterator<Pelajaran> pelajaranIter = listData.iterator();
			  		try {
			  			listData = pelajaranOpr.getPelajaran();
			  			while(pelajaranIter.hasNext()) {
			  				System.out.println("Mata Pelajaran =" + pelajaranIter.next().getNama_pelajaran());
			  				System.out.println("Jam Pelajaran =" + pelajaranIter.next().getJam_pelajaran());
			  				System.out.println("--");
			  			}
			  		} catch(Exception e) {
			  			
			  		}
			  		*/
			  		Pelajaran result = pelajaranOpr.readById(pelajaran.getId());
			  		System.out.println("\nMengambil pelajaran.....\n");
			  		System.out.println("Nama Pelajaran = " + pelajaran.getNama_pelajaran());
			  		System.out.println("Jam Pelajaran = " + pelajaran.getJam_pelajaran());
			  break;
			  case 3: System.out.println("Update Data");
			  Pelajaran edit = insert_new();
			  pelajaran.setNama_pelajaran(edit.getNama_pelajaran());
			  pelajaran.setJam_pelajaran(edit.getJam_pelajaran());
			  pelajaranOpr.update(pelajaran);
			  System.out.println("\nMengedit pelajaran.....\n");
			  System.out.println("Nama Pelajaran = " + pelajaran.getNama_pelajaran());
		  		System.out.println("Jam Pelajaran = " + pelajaran.getJam_pelajaran());
			  break;
			  case 4: System.out.println("Delete Data");
			  pelajaranOpr.deleteById(pelajaran.getId());
			  System.out.println("\nMenghapus pelajaran.....\n");
			  break;
			  case 5: System.out.println("Exit");
			  break;
			  default: System.out.println("Invalid Choice");
		  }
		}
		
		ctx.close();

	}
	
	public static int menu() {
		Scanner Input = new Scanner(System.in);
		  System.out.println("========== Main Menu ===========");
		  System.out.println("1. Insert Data");
		  System.out.println("2. Retrieve Data");
		  System.out.println("3. Update Data");
		  System.out.println("4. Delete Data");
		  System.out.println("5. Exit");
		  System.out.println("Please enter your choice : ");
		  int choice=Input.nextInt();
		  
		  return choice;	  
	}
	
	public static Pelajaran insert_new() {
		Scanner Input = new Scanner(System.in);
		System.out.println("Nama mata pelajaran: ");
		String m_pelajaran = Input.nextLine();
		System.out.println("Total jam pelajaran: ");
		int jam_pelajaran = Input.nextInt();
		
		Pelajaran pelajaran = new Pelajaran(null, m_pelajaran, jam_pelajaran);
		return pelajaran;
	}
}

