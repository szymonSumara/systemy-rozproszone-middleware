/*
 *
 * Copyright 2015 gRPC authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import * as grpc from 'grpc';

import { IAServer, AService, IBServer, BService} from '../generated/services_grpc_pb';
import AServer from './Servers/AServer';
import BServer from './Servers/BServer';

function main() {
  var server = new grpc.Server();
  server.addService<IAServer>(AService, new AServer());
  server.addService<IBServer>(BService, new BServer());
  server.bindAsync('0.0.0.0:50051', grpc.ServerCredentials.createInsecure(), () => {
   server.start();
  });
}

main();
