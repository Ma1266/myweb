package junit;

import java.util.HashSet;
import java.util.Set;

import cn.mwm.model.TRole;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class SetList {

	
	
	

	public static void main(String[] args) {
		SetList setList=new SetList();
		setList.dd();
	}
	
	private void dd() {
		Set<TRole> roleList =new	 HashSet<TRole>();
		TRole r=new TRole();
		r.setId(1);
		TRole r2=new TRole();
		r2.setId(12);
		roleList.add(r);
		roleList.add(r2);
		
		for (TRole t:roleList) {
			System.out.println(t.getId());
		}
	}
}
