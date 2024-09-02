/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.example;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Response.Status;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jbpm.util.JsonSchemaUtil;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import org.kie.kogito.process.WorkItem;
import org.kie.kogito.process.ProcessService;
import org.kie.kogito.process.workitem.Attachment;
import org.kie.kogito.process.workitem.AttachmentInfo;
import org.kie.kogito.process.workitem.Comment;
import org.kie.kogito.process.workitem.Policies;
import org.kie.kogito.process.workitem.TaskModel;
import org.kie.kogito.auth.IdentityProvider;
import org.kie.kogito.auth.IdentityProviders;
import org.kie.kogito.auth.SecurityPolicy;

@Path("/screening")
@org.eclipse.microprofile.openapi.annotations.tags.Tag(name = "screening")
@jakarta.enterprise.context.ApplicationScoped()
public class ScreeningResource {

    @jakarta.inject.Inject()
    @jakarta.inject.Named("screening")
    Process<ScreeningModel> process;

    @Inject
    ProcessService processService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "screening", description = "")
    public Response createResource_screening(@Context HttpHeaders httpHeaders, @Context UriInfo uriInfo, @QueryParam("businessKey") @DefaultValue("") String businessKey, @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() ScreeningModelInput resource) {
        ProcessInstance<ScreeningModel> pi = processService.createProcessInstance(process, businessKey, Optional.ofNullable(resource).orElse(new ScreeningModelInput()).toModel(), httpHeaders.getRequestHeaders(), httpHeaders.getHeaderString("X-KOGITO-StartFromNode"));
        return Response.created(uriInfo.getAbsolutePathBuilder().path(pi.id()).build()).entity(pi.checkError().variables().toModel()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "screening", description = "")
    public List<ScreeningModelOutput> getResources_screening() {
        return processService.getProcessInstanceOutput(process);
    }

    @GET
    @Path("schema")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "screening", description = "")
    public Map<String, Object> getResourceSchema_screening() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "screening", description = "")
    public ScreeningModelOutput getResource_screening(@PathParam("id") String id) {
        return processService.findById(process, id).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "screening", description = "")
    public ScreeningModelOutput deleteResource_screening(@PathParam("id") final String id) {
        return processService.delete(process, id).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "screening", description = "")
    public ScreeningModelOutput updateModel_screening(@PathParam("id") String id, @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() ScreeningModelInput resource) {
        return processService.update(process, id, resource.toModel()).orElseThrow(NotFoundException::new);
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "screening", description = "")
    public ScreeningModelOutput updateModelPartial_screening(@PathParam("id") String id, @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() ScreeningModelInput resource) {
        return processService.updatePartial(process, id, resource.toModel()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "screening", description = "")
    public List<TaskModel> getTasks_screening(@PathParam("id") String id, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getTasks(process, id, SecurityPolicy.of(IdentityProviders.of(user, groups))).orElseThrow(NotFoundException::new).stream().map(com.example.Screening_TaskModelFactory::from).collect(Collectors.toList());
    }

    @POST
    @Path("/{id}/jang.lang.Throwable")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ScreeningModelOutput signal_0(@PathParam("id") final String id) {
        return processService.signalProcessInstance(process, id, null, "jang.lang.Throwable").orElseThrow(() -> new NotFoundException());
    }

    @POST
    @Path("/{id}/Error_Handling")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ScreeningModelOutput signal_1(@PathParam("id") final String id) {
        return processService.signalProcessInstance(process, id, null, "Error Handling").orElseThrow(() -> new NotFoundException());
    }

    @POST
    @Path("/{id}/Officer_Feedback_Screening/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ScreeningModelOutput completeTask_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("complete") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Screening__8224575C_D745_4BE5_AAE4_80FD71B8D5CF_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Officer_Feedback_Screening/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public com.example.Screening__8224575C_D745_4BE5_AAE4_80FD71B8D5CF_TaskOutput saveTask_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Screening__8224575C_D745_4BE5_AAE4_80FD71B8D5CF_TaskOutput model) {
        return processService.saveTask(process, id, taskId, SecurityPolicy.of(user, groups), model, com.example.Screening__8224575C_D745_4BE5_AAE4_80FD71B8D5CF_TaskOutput::fromMap).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/Officer_Feedback_Screening/{taskId}/phases/{phase}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ScreeningModelOutput taskTransition_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("phase") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Screening__8224575C_D745_4BE5_AAE4_80FD71B8D5CF_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Officer_Feedback_Screening/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.example.Screening__8224575C_D745_4BE5_AAE4_80FD71B8D5CF_TaskModel getTask_Officer_Feedback_Screening_2(@PathParam("id") String id, @PathParam("taskId") String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getTask(process, id, taskId, SecurityPolicy.of(user, groups), com.example.Screening__8224575C_D745_4BE5_AAE4_80FD71B8D5CF_TaskModel::from).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Officer_Feedback_Screening/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ScreeningModelOutput abortTask_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("abort") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), null).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("Officer_Feedback_Screening/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchema_Officer_Feedback_Screening_2() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id(), "Officer_Feedback_Screening");
    }

    @GET
    @Path("/{id}/Officer_Feedback_Screening/{taskId}/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchemaAndPhases_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getSchemaAndPhases(process, id, taskId, "Officer_Feedback_Screening", SecurityPolicy.of(user, groups));
    }

    @POST
    @Path("/{id}/Officer_Feedback_Screening/{taskId}/comments")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addComment_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String commentInfo, @Context UriInfo uriInfo) {
        return processService.addComment(process, id, taskId, SecurityPolicy.of(user, groups), commentInfo).map(comment -> Response.created(uriInfo.getAbsolutePathBuilder().path(comment.getId().toString()).build()).entity(comment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Officer_Feedback_Screening/{taskId}/comments/{commentId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment updateComment_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String comment) {
        return processService.updateComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups), comment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Officer_Feedback_Screening/{taskId}/comments/{commentId}")
    public Response deleteComment_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/Officer_Feedback_Screening/{taskId}/attachments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAttachment_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachmentInfo, @Context UriInfo uriInfo) {
        return processService.addAttachment(process, id, taskId, SecurityPolicy.of(user, groups), attachmentInfo).map(attachment -> Response.created(uriInfo.getAbsolutePathBuilder().path(attachment.getId().toString()).build()).entity(attachment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Officer_Feedback_Screening/{taskId}/attachments/{attachmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment updateAttachment_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachment) {
        return processService.updateAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups), attachment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Officer_Feedback_Screening/{taskId}/attachments/{attachmentId}")
    public Response deleteAttachment_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Officer_Feedback_Screening/{taskId}/attachments/{attachmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment getAttachment_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Attachment " + attachmentId + " not found"));
    }

    @GET
    @Path("/{id}/Officer_Feedback_Screening/{taskId}/attachments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Attachment> getAttachments_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Officer_Feedback_Screening/{taskId}/comments/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getComment_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Comment " + commentId + " not found"));
    }

    @GET
    @Path("/{id}/Officer_Feedback_Screening/{taskId}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Comment> getComments_Officer_Feedback_Screening_2(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ScreeningModelOutput completeTask_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("complete") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Screening__7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public com.example.Screening__7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053_TaskOutput saveTask_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Screening__7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053_TaskOutput model) {
        return processService.saveTask(process, id, taskId, SecurityPolicy.of(user, groups), model, com.example.Screening__7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053_TaskOutput::fromMap).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}/phases/{phase}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ScreeningModelOutput taskTransition_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("phase") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Screening__7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.example.Screening__7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053_TaskModel getTask_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") String id, @PathParam("taskId") String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getTask(process, id, taskId, SecurityPolicy.of(user, groups), com.example.Screening__7DA9EC8B_B79D_42C1_B84C_22F0DD1BB053_TaskModel::from).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ScreeningModelOutput abortTask_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("abort") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), null).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("Officer_Feedback_Not_Matched_Screening/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchema_Officer_Feedback_Not_Matched_Screening_3() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id(), "Officer_Feedback_Not_Matched_Screening");
    }

    @GET
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchemaAndPhases_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getSchemaAndPhases(process, id, taskId, "Officer_Feedback_Not_Matched_Screening", SecurityPolicy.of(user, groups));
    }

    @POST
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}/comments")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addComment_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String commentInfo, @Context UriInfo uriInfo) {
        return processService.addComment(process, id, taskId, SecurityPolicy.of(user, groups), commentInfo).map(comment -> Response.created(uriInfo.getAbsolutePathBuilder().path(comment.getId().toString()).build()).entity(comment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}/comments/{commentId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment updateComment_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String comment) {
        return processService.updateComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups), comment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}/comments/{commentId}")
    public Response deleteComment_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}/attachments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAttachment_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachmentInfo, @Context UriInfo uriInfo) {
        return processService.addAttachment(process, id, taskId, SecurityPolicy.of(user, groups), attachmentInfo).map(attachment -> Response.created(uriInfo.getAbsolutePathBuilder().path(attachment.getId().toString()).build()).entity(attachment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}/attachments/{attachmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment updateAttachment_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachment) {
        return processService.updateAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups), attachment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}/attachments/{attachmentId}")
    public Response deleteAttachment_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}/attachments/{attachmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment getAttachment_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Attachment " + attachmentId + " not found"));
    }

    @GET
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}/attachments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Attachment> getAttachments_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}/comments/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getComment_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Comment " + commentId + " not found"));
    }

    @GET
    @Path("/{id}/Officer_Feedback_Not_Matched_Screening/{taskId}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Comment> getComments_Officer_Feedback_Not_Matched_Screening_3(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }
}
