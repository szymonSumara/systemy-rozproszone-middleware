import {IBServer} from '../../generated/services_grpc_pb';
import * as services_pb from '../../generated/services_pb'
import * as grpc from 'grpc';


export default class BServer implements IBServer{
    b(
        call: grpc.ServerUnaryCall<services_pb.String>, 
        callback : grpc.sendUnaryData<services_pb.String>
    ) : void {
      console.log("message", call.request.getValue());
      const response =  new services_pb.String();
      response.setValue("b message");
      callback(null, response);
    }
}