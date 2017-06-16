package com.guide.ascvd.service;

import java.util.List;

import com.guide.ascvd.pojo.ASCVD;
import com.guide.ascvd.pojo.DoctorDetail;

public interface AscvdService {
	List<DoctorDetail> dataTableDoctorDetail(int start,String keshi_name);
	List<ASCVD> queryDoctorProv();
	List<ASCVD> queryDoctorCity();
	List<ASCVD> getDoctorByCity(String selectedProvince);
	List<ASCVD> queryHospitalProv();
	List<ASCVD> queryHospitalCity();
	List<ASCVD> getHospitalByCity(String selectedProvince);
	List<ASCVD> queryDateCourseReg();
	List<ASCVD> queryCoursePatientViewer();
	List<ASCVD> queryCourse();
	List<ASCVD> queryCourseDoctorPatient();
	List<ASCVD> queryKeShi();
	int dataTableDoctorDetailCount(String str);
}
