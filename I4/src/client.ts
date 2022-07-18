import * as grpc from 'grpc';
import * as services from '../generated/services_grpc_pb'
import {String as tString} from '../generated/services_pb'

async function main() {

  const target = 'localhost:8080';
  
  const a = new services.AClient(target, grpc.credentials.createInsecure());
  const b = new services.BClient(target, grpc.credentials.createInsecure());
  const c = new services.CClient(target, grpc.credentials.createInsecure());
  
  const callback = (err : grpc.ServiceError, res : tString) => {
    if(err) return console.log(err)
    console.log(err,res.getValue() )
  }

  const aMessage = new tString(); aMessage.setValue("a call");
  const bMessage = new tString(); bMessage.setValue("b call");
  const cMessage = new tString(); cMessage.setValue("c call");

  a.a(aMessage, callback);
  b.b(bMessage, callback);
  c.c(cMessage, callback);
  b.b(bMessage, callback);
  c.c(cMessage, callback);
  a.a(aMessage, callback);
  b.b(bMessage, callback);
  a.a(aMessage, callback);
  c.c(cMessage, callback);
  a.a(aMessage, callback);
  b.b(bMessage, callback);
  c.c(cMessage, callback);
  a.a(aMessage, callback);
}

main();
