// package: services
// file: services.proto

/* tslint:disable */
/* eslint-disable */

import * as grpc from "grpc";
import * as services_pb from "./services_pb";

interface IAService extends grpc.ServiceDefinition<grpc.UntypedServiceImplementation> {
    a: IAService_Ia;
}

interface IAService_Ia extends grpc.MethodDefinition<services_pb.String, services_pb.String> {
    path: "/services.A/a";
    requestStream: false;
    responseStream: false;
    requestSerialize: grpc.serialize<services_pb.String>;
    requestDeserialize: grpc.deserialize<services_pb.String>;
    responseSerialize: grpc.serialize<services_pb.String>;
    responseDeserialize: grpc.deserialize<services_pb.String>;
}

export const AService: IAService;

export interface IAServer {
    a: grpc.handleUnaryCall<services_pb.String, services_pb.String>;
}

export interface IAClient {
    a(request: services_pb.String, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
    a(request: services_pb.String, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
    a(request: services_pb.String, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
}

export class AClient extends grpc.Client implements IAClient {
    constructor(address: string, credentials: grpc.ChannelCredentials, options?: object);
    public a(request: services_pb.String, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
    public a(request: services_pb.String, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
    public a(request: services_pb.String, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
}

interface IBService extends grpc.ServiceDefinition<grpc.UntypedServiceImplementation> {
    b: IBService_Ib;
}

interface IBService_Ib extends grpc.MethodDefinition<services_pb.String, services_pb.String> {
    path: "/services.B/b";
    requestStream: false;
    responseStream: false;
    requestSerialize: grpc.serialize<services_pb.String>;
    requestDeserialize: grpc.deserialize<services_pb.String>;
    responseSerialize: grpc.serialize<services_pb.String>;
    responseDeserialize: grpc.deserialize<services_pb.String>;
}

export const BService: IBService;

export interface IBServer {
    b: grpc.handleUnaryCall<services_pb.String, services_pb.String>;
}

export interface IBClient {
    b(request: services_pb.String, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
    b(request: services_pb.String, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
    b(request: services_pb.String, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
}

export class BClient extends grpc.Client implements IBClient {
    constructor(address: string, credentials: grpc.ChannelCredentials, options?: object);
    public b(request: services_pb.String, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
    public b(request: services_pb.String, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
    public b(request: services_pb.String, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
}

interface ICService extends grpc.ServiceDefinition<grpc.UntypedServiceImplementation> {
    c: ICService_Ic;
}

interface ICService_Ic extends grpc.MethodDefinition<services_pb.String, services_pb.String> {
    path: "/services.C/c";
    requestStream: false;
    responseStream: false;
    requestSerialize: grpc.serialize<services_pb.String>;
    requestDeserialize: grpc.deserialize<services_pb.String>;
    responseSerialize: grpc.serialize<services_pb.String>;
    responseDeserialize: grpc.deserialize<services_pb.String>;
}

export const CService: ICService;

export interface ICServer {
    c: grpc.handleUnaryCall<services_pb.String, services_pb.String>;
}

export interface ICClient {
    c(request: services_pb.String, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
    c(request: services_pb.String, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
    c(request: services_pb.String, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
}

export class CClient extends grpc.Client implements ICClient {
    constructor(address: string, credentials: grpc.ChannelCredentials, options?: object);
    public c(request: services_pb.String, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
    public c(request: services_pb.String, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
    public c(request: services_pb.String, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: services_pb.String) => void): grpc.ClientUnaryCall;
}
