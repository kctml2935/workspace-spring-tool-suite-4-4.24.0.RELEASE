package com.itwill.address.test;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

public class AddressServiceTestMain {

	public static void main(String[] args) throws Exception {
		AddressService addressService=new AddressService();
		System.out.println("1.주소록쓰기");
		System.out.println(">> insert row count"+addressService.addressWrite(new Address(0, "새사람", "000-9999", "새나라")));
		
		
		System.out.println("2.주소록리스트");
		System.out.println(addressService.addressList());
		System.out.println("3.주소록상세보기");
		Address address=addressService.addressDetail(43);
		System.out.println(address);
		System.out.println("4.주소록수정");
		address.setName("수정이름");
		address.setAddress("경상도");
		address.setPhone("888-8888");
		System.out.println(">> update row count:"+addressService.addressUpdate(address));
		System.out.println("5.주소록삭제");
		System.out.println(">> delete row count:"+addressService.addressDelete(15));

	}

}
