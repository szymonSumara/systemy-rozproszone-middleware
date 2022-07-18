// GENERATED CODE -- DO NOT EDIT!

// Original file comments:
// Copyright 2015, Google Inc.
// All rights reserved.
// 
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:
// 
//     * Redistributions of source code must retain the above copyright
// notice, this list of conditions and the following disclaimer.
//     * Redistributions in binary form must reproduce the above
// copyright notice, this list of conditions and the following disclaimer
// in the documentation and/or other materials provided with the
// distribution.
//     * Neither the name of Google Inc. nor the names of its
// contributors may be used to endorse or promote products derived from
// this software without specific prior written permission.
// 
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
// A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
// OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
// LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//
'use strict';
var grpc = require('grpc');
var services_pb = require('./services_pb.js');

function serialize_services_String(arg) {
  if (!(arg instanceof services_pb.String)) {
    throw new Error('Expected argument of type services.String');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_services_String(buffer_arg) {
  return services_pb.String.deserializeBinary(new Uint8Array(buffer_arg));
}


var AService = exports.AService = {
  a: {
    path: '/services.A/a',
    requestStream: false,
    responseStream: false,
    requestType: services_pb.String,
    responseType: services_pb.String,
    requestSerialize: serialize_services_String,
    requestDeserialize: deserialize_services_String,
    responseSerialize: serialize_services_String,
    responseDeserialize: deserialize_services_String,
  },
};

exports.AClient = grpc.makeGenericClientConstructor(AService);
var BService = exports.BService = {
  b: {
    path: '/services.B/b',
    requestStream: false,
    responseStream: false,
    requestType: services_pb.String,
    responseType: services_pb.String,
    requestSerialize: serialize_services_String,
    requestDeserialize: deserialize_services_String,
    responseSerialize: serialize_services_String,
    responseDeserialize: deserialize_services_String,
  },
};

exports.BClient = grpc.makeGenericClientConstructor(BService);
var CService = exports.CService = {
  c: {
    path: '/services.C/c',
    requestStream: false,
    responseStream: false,
    requestType: services_pb.String,
    responseType: services_pb.String,
    requestSerialize: serialize_services_String,
    requestDeserialize: deserialize_services_String,
    responseSerialize: serialize_services_String,
    responseDeserialize: deserialize_services_String,
  },
};

exports.CClient = grpc.makeGenericClientConstructor(CService);
