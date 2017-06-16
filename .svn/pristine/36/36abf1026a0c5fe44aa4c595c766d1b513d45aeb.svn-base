package com.guide.community.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backup.CommunityDateCourseReg;
import com.backup.CommunityDateCourseRegService;
import com.backup.CommunityDetailInfo;
import com.backup.CommunityDetailInfoService;
import com.backup.CommunityDoc;
import com.backup.CommunityDocService;
import com.backup.CommunityHospital;
import com.backup.CommunityHospitalService;
import com.backup.CommunityKecheng;
import com.backup.CommunityKechengDoctorPatient;
import com.backup.CommunityKechengDoctorPatientService;
import com.backup.CommunityKechengPatientViewer;
import com.backup.CommunityKechengPatientViewerService;
import com.backup.CommunityKechengService;
import com.backup.CommunityKeshi;
import com.backup.CommunityKeshiService;
import com.backup.Course;
import com.backup.CourseDoctorPatient;
import com.backup.CoursePatientViewer;
import com.backup.DateCourseReg;
import com.backup.DetailInfo;
import com.backup.Doctor;
import com.backup.Hospital;
import com.backup.Keshi;
import com.guide.ascvd.pojo.DoctorDetail;
import com.guide.community.pojo.Community;
import com.guide.community.service.CommunityService;
import com.guide.utils.JsonUtil;

@Controller
@RequestMapping("/community")
public class CommunityController {
	@Resource(name = "CommunityService")
	private CommunityService communityService;

	private Logger logger;

	public CommunityController() {
		this.logger = Logger.getLogger(CommunityController.class);
	}

	// 登录验证---成功
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "hospital", method = RequestMethod.GET)
	public String comValidate(HttpServletRequest request) {
		List<Community> doc_prov = communityService.queryDoctorProv();
		List<Community> doc_city = communityService.queryDoctorCity();
		List<Community> hos_prov = communityService.queryHospitalProv();
		List<Community> hos_city = communityService.queryHospitalCity();
		List<Community> keshi_list = communityService.queryKeShi();
		JSONArray Doc_arr_prov = new JSONArray();
		for (Community doc : doc_prov) {
			JSONObject Doc_obj = new JSONObject();
			Doc_obj.put("name", doc.getSerialName());
			Doc_obj.put("value", doc.getSerialCount1());
			Doc_arr_prov.add(Doc_obj);
		}
		JSONArray Doc_arr_city = new JSONArray();
		for (Community doc : doc_city) {
			JSONObject Doc_obj = new JSONObject();
			Doc_obj.put("name", doc.getSerialName());
			Doc_obj.put("value", doc.getSerialCount1());
			Doc_arr_city.add(Doc_obj);
		}
		JSONArray Hos_arr_prov = new JSONArray();
		for (Community hos : hos_prov) {
			JSONObject Hos_obj = new JSONObject();
			Hos_obj.put("name", hos.getSerialName());
			Hos_obj.put("value", hos.getSerialCount1());
			Hos_arr_prov.add(Hos_obj);
		}
		JSONArray Hos_arr_city = new JSONArray();
		for (Community hos : hos_city) {
			JSONObject Hos_obj = new JSONObject();
			Hos_obj.put("name", hos.getSerialName());
			Hos_obj.put("value", hos.getSerialCount1());
			Hos_arr_city.add(Hos_obj);
		}
		request.setAttribute("Doc_prov", Doc_arr_prov);
		request.setAttribute("Doc_city", Doc_arr_city);
		request.setAttribute("Hos_prov", Hos_arr_prov);
		request.setAttribute("Hos_city", Hos_arr_city);
		request.setAttribute("Pie_keshi", keshi_list);
		return "community/hospital";
	}

	@RequestMapping(value = "course", method = RequestMethod.GET)
	public String course(HttpServletRequest request) {
		List<Community> course_list = communityService.queryCourse();
		request.setAttribute("Pie_course", course_list);
		return "community/course";
	}

	@RequestMapping(value = "date", method = RequestMethod.GET)
	public String date(HttpServletRequest request) {
		List<Community> datecoursereg_list = communityService.queryDateCourseReg();
		request.setAttribute("Line_date", datecoursereg_list);
		return "community/date";
	}

	@RequestMapping(value = "query_detailinfo", method = RequestMethod.GET)
	public String query_detailinfo(HttpServletRequest request) {
		return "community/query_detailinfo";
	}

	@RequestMapping(value = "patient", method = RequestMethod.GET)
	public String patient(HttpServletRequest request) {
		List<Community> CourseDoctorPatient_list = communityService.queryCourseDoctorPatient();
		List<Community> CoursePatientViewer_list = communityService.queryCoursePatientViewer();
		request.setAttribute("Bar_doctor", CourseDoctorPatient_list);
		request.setAttribute("Bar_viewer", CoursePatientViewer_list);
		return "community/patient";
	}

	@RequestMapping(value = "ajaxcity_data", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String hypt(HttpServletRequest request, @RequestParam("selectedProvince") String selectedProvince)
			throws Exception {
		List<Community> list = communityService.getDoctorByCity(selectedProvince);
		return JsonUtil.object2json(list);
	}

	@RequestMapping(value = "ajaxhoscity_data", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String gethoscity_data(HttpServletRequest request, @RequestParam("selectedProvince") String selectedProvince)
			throws Exception {
		List<Community> list = communityService.getHospitalByCity(selectedProvince);
		return JsonUtil.object2json(list);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "datatable_query", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String datatable_query(HttpServletRequest request, @RequestParam("search[value]") String search,
			@RequestParam("draw") int draw, @RequestParam("start") int start) throws Exception {
		String str = request.getParameter("search[value]");
		if (str == "" || str.equals("")) {
			str = "心内";
		}
		if (str.endsWith("'")) {
			str = str.substring(0, str.length() - 1);
		}
		int len = communityService.dataTableDoctorDetailCount(str);
		List<DoctorDetail> list = communityService.dataTableDoctorDetail(start, str);
		JSONObject json = new JSONObject();
		List<List<String>> list1 = new ArrayList<List<String>>();
		List<String> list2 = new ArrayList<String>();

		for (DoctorDetail i : list) {
			list2.add(i.getCityName());
			list2.add(i.getDoctorName());
			list2.add(i.getHospitalName());
			list2.add(i.getKeShiName());
			list1.add(list2);
			list2 = new ArrayList<String>();
		}
		json.put("data", list1);
		json.put("recordsTotal", len);
		json.put("recordsFiltered", len);
		json.put("draw", draw);
		return json.toJSONString();
	}

}
