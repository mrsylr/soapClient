package com.kolaysoft.peyk.soapclient.service;

import com.kolaysoft.peyk.soapclient.ws.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;
import java.util.Map;

@Component
public class PeykServiceClient {

    private final PeykService peykService;
    @Value("${peyk.ws.url}")
    private String URL;

    public PeykServiceClient(PeykService peykService) {
        this.peykService = peykService;
    }

    public IlPyld CallGetIlLer() {

        GetIller request = new GetIller();
        IlPyld response = ((GetIllerResponse) peykService.performRequest(URL, request)).getReturn();
        return response;

    }

    public IlcePyld CallGetIlceler() {

        GetIlceler request = new GetIlceler();
        request.setIlId(27);
        IlcePyld response = ((GetIlcelerResponse) peykService.performRequest(URL, request)).getReturn();
        return response;


    }

    public EmployeeListDto CallGetEmployee(Integer page, Integer size) {

        GetEmployee request = new GetEmployee();
        request.setPage(page);
        request.setSize(size);
        EmployeeListDto response = ((GetEmployeeResponse) peykService.performRequest(URL, request)).getReturn();
        return response;

    }

    public EmployeeGetPyld CallEmployeeByTckn(String tckno) {

        GetEmployeeByTckn request = new GetEmployeeByTckn();
        request.setTckn(tckno);
        EmployeeGetPyld response = ((GetEmployeeByTcknResponse) peykService.performRequest(URL, request)).getReturn();
        return response;

    }

    public EmployeeResultPyld UpdateEmployeeStatus(List<String> tckNoList, Integer activasyonStatus) {

        UpdateEmployeeStatus request = new UpdateEmployeeStatus();
        request.setActivationStatus(activasyonStatus);
        for (String tckno : tckNoList) {
            request.getEmployeeTcknList().add(tckno);
        }

        EmployeeResultPyld response = ((UpdateEmployeeStatusResponse) peykService.performRequest(URL, request)).getReturn();
        return response;


    }

    public EmployeeResultPyld ImportMultipleEmployees(List<EmployeePyld> employeeList) {

        ImportMultipleEmployees request = new ImportMultipleEmployees();
        for (EmployeePyld employee : employeeList) {
            request.getEmployees().add(employee);
        }
        EmployeeResultPyld response = ((ImportMultipleEmployeesResponse) peykService.performRequest(URL, request)).getReturn();
        return response;
    }

    public DocumentListPyld GetBordroByEmployee(String tckno, Integer page, Integer size) {

        GetBordroByEmployee request = new GetBordroByEmployee();
        request.setTckn(tckno);
        request.setPage(page);
        request.setSize(size);

        DocumentListPyld response = ((GetBordroByEmployeeResponse) peykService.performRequest(URL, request)).getReturn();

        return response;
    }

    public DocumentListPyld GetBordroByDateRange(String startDate, String endDate, Integer page, Integer size) throws DatatypeConfigurationException {

        XMLGregorianCalendar start = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(startDate);
        XMLGregorianCalendar end = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(startDate);

        GetBordroByDateRange request = new GetBordroByDateRange();
        request.setStart(start);
        request.setStart(end);
        request.setPage(page);
        request.setSize(size);

        DocumentListPyld response = ((GetBordroByDateRangeResponse) peykService.performRequest(URL, request)).getReturn();

        return response;

    }

    public DocumentResultPyld ImportBordroByByteArray(String fileName, Integer month, Integer year, byte[] bulkBytes) {

        ImportBordroByByteArray request = new ImportBordroByByteArray();
        request.setFileName(fileName);
        request.setMonth(month);
        request.setYear(year);
        request.setBulkBytes(bulkBytes);

        DocumentResultPyld response = ((ImportBordroByByteArrayResponse) peykService.performRequest(URL, request)).getReturn();

        return response;
    }
    public DocumentResultPyld ImportFormByByteArrayRunSync(String fileName, String notificationTitle, List<String> employeeTckNoList, Boolean isAnswerMandatory, byte[] bulkBytes) {

        ImportFormByByteArrayRunSync   request = new ImportFormByByteArrayRunSync();
        request.setFileName(fileName);
        request.setBulkBytes(bulkBytes);
        request.setIsAnswerMandatory(isAnswerMandatory);
        request.setNotificationTitle(notificationTitle);
        for (String tckno : employeeTckNoList) {
            request.getEmployeeTcknList().add(tckno);
        }
        DocumentResultPyld response = ((ImportFormByByteArrayRunSyncResponse) peykService.performRequest(URL, request)).getReturn();

        return response;
    }

    public DocumentResultPyld ImportMultipleBordrosByAttachment(Integer month, Integer year, Map<String, DataHandler> attachments) {


        ImportMultipleBordrosByAttachment request = new ImportMultipleBordrosByAttachment();
        request.setMonth(month);
        request.setYear(year);


        DocumentResultPyld response = ((ImportMultipleBordrosByAttachmentResponse) peykService.performRequest(URL, request, attachments)).getReturn();

        return response;
    }

    public PersonalInfoAttachmentsResultPyld SavePersonalInfoNotAttachedFiles(String tckn,
                                                                              String attachmentName,
                                                                              Integer surveyId,
                                                                              byte[] bulkBytes,
                                                                              Boolean isReplaceWithExisting) {


        SavePersonalInfoNotAttachedFiles request = new SavePersonalInfoNotAttachedFiles();
        request.setTckn(tckn);
        request.setAttachmentName(attachmentName);
        request.setSurveyId(surveyId);
        request.setBulkBytes(bulkBytes);
        request.setIsReplaceWithExisting(isReplaceWithExisting);


        PersonalInfoAttachmentsResultPyld response = ((SavePersonalInfoNotAttachedFilesResponse) peykService.performRequest(URL, request)).getReturn();

        return response;
    }


}
