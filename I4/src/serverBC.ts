import * as grpc from 'grpc';

import {IBServer, BService, ICServer, CService} from '../generated/services_grpc_pb';
import BServer from './Servers/BServer';
import CServer from './Servers/CServer';

function main() {
  var server = new grpc.Server();
  server.addService<IBServer>(BService, new BServer());
  server.addService<ICServer>(CService, new CServer());
  server.bindAsync('0.0.0.0:50052', grpc.ServerCredentials.createInsecure(), () => {
   server.start();
  });
}

main();