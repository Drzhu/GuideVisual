package com.guide.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guide.ascvd.pojo.DoctorDetail;
import com.guide.community.pojo.Community;

public interface CommunityMapper {
	List<DoctorDetail> dataTableDoctorDetail(@Param("start") int start, @Param("keshi_name") String keshi_name);
	List<Community> queryDoctorProv();
	List<Community> queryDoctorCity();
	List<Community> getDoctorByCity(String selectedProvince);
	
	List<Community> queryHospitalProv();
	List<Community> queryHospitalCity();
	List<Community> getHospitalByCity(String selectedProvince);
	List<Community> queryDateCourseReg();
	List<Community> queryCoursePatientViewer();
	List<Community> queryCourse();
	List<Community> queryCourseDoctorPatient();
	List<Community> queryKeShi();
	int dataTableDoctorDetailCount(String str);
}
