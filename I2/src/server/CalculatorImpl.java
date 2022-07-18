package server;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import sr.grpc.gen.ArithmeticOpResult;
import sr.grpc.gen.CalculatorGrpc;
import sr.grpc.gen.MullRequest;
import sr.grpc.gen.MullResult;

public class CalculatorImpl extends CalculatorGrpc.CalculatorImplBase
{
	@Override
	public void add(sr.grpc.gen.ArithmeticOpArguments request,
			io.grpc.stub.StreamObserver<sr.grpc.gen.ArithmeticOpResult> responseObserver) 
	{

		System.out.println(request.toByteString());
		System.out.println("addRequest (" + request.getArg1() + ", " + request.getArg2() +")");
		int val = request.getArg1() + request.getArg2();
		ArithmeticOpResult result = ArithmeticOpResult.newBuilder().setRes(val).build();
		if(request.getArg1() > 100 && request.getArg2() > 100) try { Thread.sleep(5000); } catch(java.lang.InterruptedException ex) { }
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}

	@Override
	public void subtract(sr.grpc.gen.ArithmeticOpArguments request,
			io.grpc.stub.StreamObserver<sr.grpc.gen.ArithmeticOpResult> responseObserver) 
	{
		System.out.println("subtractRequest (" + request.getArg1() + ", " + request.getArg2() +")");

		int val = request.getArg1() - request.getArg2();
		ArithmeticOpResult result = ArithmeticOpResult.newBuilder().setRes(val).build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}

	@Override
	public void mull(MullRequest request, StreamObserver<MullResult> responseObserver) {
		System.out.println("mull (" + request.getResList() +")");


		//responseObserver.onError(io.grpc.Status.INVALID_ARGUMENT.withDescription("Bad arguments").asRuntimeException());

		if( request.getResList().size() == 0){
			Status status = Status.FAILED_PRECONDITION.withDescription("Not between 2 and 20");
			responseObserver.onError(status.asRuntimeException());
			return;
		}
			int result = 1;
			//if(request.getResList().size() == 0){ responseObserver.onCompleted(); return;}
			for (int number : request.getResList()) {
				result*=number;
			}
			MullResult resultFrame = MullResult.newBuilder().setRes(result).build();
			responseObserver.onNext(resultFrame);
			responseObserver.onCompleted();


	}
}
