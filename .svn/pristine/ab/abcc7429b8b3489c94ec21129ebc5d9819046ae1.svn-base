package com.guide.ascvd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guide.ascvd.pojo.ASCVD;
import com.guide.ascvd.pojo.DoctorDetail;

public interface AscvdMapper {
	List<DoctorDetail> dataTableDoctorDetail(@Param("start") int start, @Param("keshi_name") String keshi_name);
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
