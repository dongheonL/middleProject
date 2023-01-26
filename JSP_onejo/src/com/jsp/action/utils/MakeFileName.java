package com.jsp.action.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jsp.dto.AppointmentAttachVO;
import com.jsp.dto.NomalAffairsAttachVO;
import com.jsp.dto.NotificationAttachVO;
import com.jsp.dto.QualificationAttachVO;
import com.jsp.dto.TeacherAffairsAttachVO;
import com.jsp.dto.WeeklyReportAttachVO;

public class MakeFileName {

	public static String toUUIDFileName(String fileName, String delimiter) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimiter + fileName;
	}

	public static String parseFileNameFromUUID(String fileName, String delimiter) {
		String[] uuidFileName = fileName.split(delimiter);
		return uuidFileName[uuidFileName.length - 1];
	}

	public static List<WeeklyReportAttachVO> parseFileNameFromWeeklyReportAttaches(
			List<WeeklyReportAttachVO> attachList, String delimiter) {

		List<WeeklyReportAttachVO> renamedAttachList = new ArrayList<WeeklyReportAttachVO>();

		if (attachList != null) {
			for (WeeklyReportAttachVO attach : attachList) {
				String fileName = attach.getFileName(); // DB상의 fileName
				fileName = parseFileNameFromUUID(fileName, delimiter); // uuid가 제거된
				// fileName
				attach.setFileName(fileName);

				renamedAttachList.add(attach);
			}
		}
		return renamedAttachList;
	}

	public static List<NotificationAttachVO> parseFileNameFromNotificationAttaches(
			List<NotificationAttachVO> attachList, String delimiter) {

		List<NotificationAttachVO> renamedAttachList = new ArrayList<NotificationAttachVO>();

		if (attachList != null) {
			for (NotificationAttachVO attach : attachList) {
				String fileName = attach.getFileName(); // DB상의 fileName
				fileName = parseFileNameFromUUID(fileName, delimiter); // uuid가 제거된
// fileName
				attach.setFileName(fileName);

				renamedAttachList.add(attach);
			}
		}
		return renamedAttachList;
	}
	public static List<AppointmentAttachVO> parseFileNameFromAppointmentAttaches(List<AppointmentAttachVO> attachList,
			String delimiter) {

		List<AppointmentAttachVO> renamedAttachList = new ArrayList<AppointmentAttachVO>();

		if (attachList != null) {
			for (AppointmentAttachVO attach : attachList) {
				String fileName = attach.getFileName(); // DB상의 fileName
				fileName = parseFileNameFromUUID(fileName, delimiter); // uuid가 제거된
				// fileName
				attach.setFileName(fileName);

				renamedAttachList.add(attach);
			}
		}
		return renamedAttachList;
	}
	
	public static List<QualificationAttachVO> parseFileNameFromQualificationAttaches(List<QualificationAttachVO> attachList,
			String delimiter) {

		List<QualificationAttachVO> renamedAttachList = new ArrayList<QualificationAttachVO>();

		if (attachList != null) {
			for (QualificationAttachVO attach : attachList) {
				String fileName = attach.getFileName(); // DB상의 fileName
				fileName = parseFileNameFromUUID(fileName, delimiter); // uuid가 제거된
// fileName
				attach.setFileName(fileName);

				renamedAttachList.add(attach);
			}
		}
		return renamedAttachList;
	}
	
	public static List<TeacherAffairsAttachVO> parseFileNameFromTeacherAffairsAttaches(List<TeacherAffairsAttachVO>teacherAttachList,String delimiter){
		List<TeacherAffairsAttachVO>renamedTeacherAttachList = new ArrayList<TeacherAffairsAttachVO>();
		
		if(teacherAttachList != null) {
			for(TeacherAffairsAttachVO attach : teacherAttachList) {
				String fileName = attach.getFileName();
				fileName = parseFileNameFromUUID(fileName, delimiter);
				attach.setFileName(fileName);
				
				renamedTeacherAttachList.add(attach);
			}
		}
		return renamedTeacherAttachList;
	}
	
	public static List<NomalAffairsAttachVO> parseFileNameFromNomalAffairsAttaches(List<NomalAffairsAttachVO>nomalAttachList,String delimiter){
		List<NomalAffairsAttachVO>renamedNomalAttachList = new ArrayList<NomalAffairsAttachVO>();
		
		if(nomalAttachList != null) {
			for(NomalAffairsAttachVO attach : nomalAttachList) {
				String fileName = attach.getFileName();
				fileName = parseFileNameFromUUID(fileName, delimiter);
				attach.setFileName(fileName);
				
				renamedNomalAttachList.add(attach);
			}
		}
		return renamedNomalAttachList;
	}
	

}
