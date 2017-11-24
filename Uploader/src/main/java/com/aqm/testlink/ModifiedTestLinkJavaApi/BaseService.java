package com.aqm.testlink.ModifiedTestLinkJavaApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;

import br.eti.kinoshita.testlinkjavaapi.constants.TestLinkParams;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import br.eti.kinoshita.testlinkjavaapi.util.Util;

abstract class BaseService {

    private static final Integer FALSE_IN_PHP = 0;

    /**
     * XML-RPC client.
     */
    private XmlRpcClient xmlRpcClient;

    /**
     * TestLink User devkey.
     */
    private String devKey;

    /**
     * @param xmlRpcClient XML-RPC Client.
     * @param devKey TestLink user DevKey.
     */
    public BaseService(XmlRpcClient xmlRpcClient, String devKey) {
        this.xmlRpcClient = xmlRpcClient;
        this.devKey = devKey;
    }

    /**
     * Executes the XML-RPC call to the method in the server, passing the execution data map.
     *
     * @param methodName name of the method.
     * @param executionData execution data map.
     * @return Server response.
     * @throws XmlRpcException
     */
    public Object executeXmlRpcCall(String methodName, Map<String, Object> executionData)
            throws XmlRpcException, TestLinkAPIException {
        List<Object> params = new ArrayList<Object>();

        if (executionData != null) {
            if (executionData.get(TestLinkParams.DEV_KEY.toString()) == null) {
                executionData.put(TestLinkParams.DEV_KEY.toString(), this.devKey);
            }
            params.add(executionData);
        }

        final Object o = this.xmlRpcClient.execute(methodName, params);
        this.checkResponseError(o);
        return o;
    }

    /**
     * @param response
     */
    @SuppressWarnings("unchecked")
    protected void checkResponseError(Object response) throws TestLinkAPIException {
        // may be an array of errors (IXError)
        if (response instanceof Object[]) {
            final Object[] responseArray = Util.castToArray(response);
            for (int i = 0; i < responseArray.length; i++) {
                Object maybeAMap = responseArray[i];
                // may be a map with error code and message
                if (maybeAMap instanceof Map<?, ?>) {
                    Map<String, Object> errorMap = (Map<String, Object>) maybeAMap;
                    Integer code = Util.getInteger(errorMap, "code");
                    String message = Util.getString(errorMap, "message");

                    if (code != null) {
                        throw new TestLinkAPIException(code, message);
                    }

                } // endif
            } // endfor
        } else if (response instanceof Map<?, ?>) {
            final Map<String, Object> errorMap = (Map<String, Object>) response;
            final Integer statusOk = Util.getInteger(errorMap, "status_ok");
            final String message = Util.getString(errorMap, "msg");
            if (statusOk != null && statusOk.equals(FALSE_IN_PHP)) {
                throw new TestLinkAPIException(statusOk, message);
            }
        }
    }

}
