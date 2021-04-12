//---------------------------------------------------------------------------
// Copyright (c) 2020, SAS Institute Inc., Cary, NC, USA.  All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
//---------------------------------------------------------------------------

package org.odpi.openmetadata.connector.sas.auditlog;

import org.odpi.openmetadata.frameworks.auditlog.messagesets.AuditLogMessageDefinition;
import org.odpi.openmetadata.frameworks.auditlog.messagesets.AuditLogMessageSet;
import org.odpi.openmetadata.repositoryservices.auditlog.OMRSAuditLogRecordSeverity;

/**
 * The AuditCode is used to define the message content for the OMRS Audit Log.
 *
 * The 5 fields in the enum are:
 * <ul>
 *     <li>Log Message Id - to uniquely identify the message</li>
 *     <li>Severity - is this an event, decision, action, error or exception</li>
 *     <li>Log Message Text - includes placeholder to allow additional values to be captured</li>
 *     <li>Additional Information - further parameters and data relating to the audit message (optional)</li>
 *     <li>SystemAction - describes the result of the situation</li>
 *     <li>UserAction - describes how a user should correct the situation</li>
 * </ul>
 */
public enum AuditCode implements AuditLogMessageSet {

    REPOSITORY_SERVICE_STARTING("OMRS-CATALOG-REPOSITORY-0001",
            OMRSAuditLogRecordSeverity.INFO,
            "The SAS Catalog proxy is starting a new server instance",
            "The local server has started up a new instance of the SAS Catalog proxy.",
            "No action is required.  This is part of the normal operation of the service."),
    CONNECTING_TO_CATALOG("OMRS-CATALOG-REPOSITORY-0002",
            OMRSAuditLogRecordSeverity.INFO,
            "The SAS Catalog proxy is attempting to connect to SAS Catalog at {0}",
            "The local server is attempting to connect to the SAS Catalog server.",
            "No action is required.  This is part of the normal operation of the service."),
    CONNECTED_TO_CATALOG("OMRS-CATALOG-REPOSITORY-0003",
            OMRSAuditLogRecordSeverity.INFO,
            "The SAS Catalog proxy has successfully connected to SAS Catalog at {0}",
            "The local server has successfully connected to the SAS Catalog server.",
            "No action is required.  This is part of the normal operation of the service."),
    REPOSITORY_SERVICE_STARTED("OMRS-CATALOG-REPOSITORY-0004",
            OMRSAuditLogRecordSeverity.INFO,
            "The SAS Catalog proxy has started a new instance for server {0}",
            "The local server has completed startup of a new instance.",
            "No action is required.  This is part of the normal operation of the service."),
    REPOSITORY_SERVICE_SHUTDOWN("OMRS-CATALOG-REPOSITORY-0005",
            OMRSAuditLogRecordSeverity.INFO,
            "The SAS Catalog proxy has shutdown its instance for server {0}",
            "The local server has requested shut down of an SAS Catalog proxy instance.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_INITIALIZING("OMRS-CATALOG-REPOSITORY-0006",
            OMRSAuditLogRecordSeverity.INFO,
            "The SAS Catalog event mapper is initializing",
            "The local server has started up a new instance of the SAS Catalog event mapper.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_INITIALIZED("OMRS-CATALOG-REPOSITORY-0007",
            OMRSAuditLogRecordSeverity.INFO,
            "The SAS Catalog event mapper has initialized for server {0}",
            "The local server has completed initialization of a new instance.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_SHUTDOWN("OMRS-CATALOG-REPOSITORY-0008",
            OMRSAuditLogRecordSeverity.INFO,
            "The SAS Catalog event mapper has shutdown its instance for server {0}",
            "The local server has requested shut down of an SAS Catalog event mapper instance.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_STARTING("OMRS-CATALOG-REPOSITORY-0009",
            OMRSAuditLogRecordSeverity.INFO,
            "The SAS Catalog event mapper consumer thread is starting up",
            "The local server has requested startup of an SAS Catalog event mapper consumer.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_RUNNING("OMRS-CATALOG-REPOSITORY-0010",
            OMRSAuditLogRecordSeverity.INFO,
            "The SAS Catalog event mapper is running",
            "The local server is now running a consumer thread for SAS Catalog.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_CONSUMER_FAILURE("OMRS-CATALOG-REPOSITORY-0011",
            OMRSAuditLogRecordSeverity.EXCEPTION,
            "The SAS Catalog event mapper failed to consume an event",
            "The local server failed to consume an SAS Catalog event.",
            "Investigate the logs for additional information and raise a GitHub issue with the details."),
    ;

    private String logMessageId;
    private OMRSAuditLogRecordSeverity severity;
    private String logMessage;
    private String systemAction;
    private String userAction;


    /**
     * The constructor for OMRSAuditCode expects to be passed one of the enumeration rows defined in
     * OMRSAuditCode above.   For example:
     * <p>
     * OMRSAuditCode   auditCode = OMRSAuditCode.SERVER_NOT_AVAILABLE;
     * <p>
     * This will expand out to the 4 parameters shown below.
     *
     * @param messageId    - unique Id for the message
     * @param severity     - the severity of the message
     * @param message      - text for the message
     * @param systemAction - description of the action taken by the system when the condition happened
     * @param userAction   - instructions for resolving the situation, if any
     */
    AuditCode(String messageId, OMRSAuditLogRecordSeverity severity, String message,
              String systemAction, String userAction) {
        this.logMessageId = messageId;
        this.severity = severity;
        this.logMessage = message;
        this.systemAction = systemAction;
        this.userAction = userAction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuditLogMessageDefinition getMessageDefinition() {
        return new AuditLogMessageDefinition(logMessageId,
                severity,
                logMessage,
                systemAction,
                userAction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuditLogMessageDefinition getMessageDefinition(String ...params) {
        AuditLogMessageDefinition messageDefinition = new AuditLogMessageDefinition(logMessageId,
                severity,
                logMessage,
                systemAction,
                userAction);
        messageDefinition.setMessageParameters(params);
        return messageDefinition;
    }

}
