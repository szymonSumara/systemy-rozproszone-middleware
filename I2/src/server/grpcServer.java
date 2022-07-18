package server;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;



public class grpcServer 
{
	private static final Logger logger = Logger.getLogger(grpcServer.class.getName());

	private int port = 50051;
	private Server server;

	private void start() throws IOException 
	{
		
		//You will want to employ flow-control so that the queue doesn't blow up your memory. You can cast StreamObserver to CallStreamObserver to get flow-control API
		
		server = /*ServerBuilder*/NettyServerBuilder.forPort(port).executor(Executors.newFixedThreadPool(16))
				.addService(new CalculatorImpl())
				.addService(ProtoReflectionService.newInstance())
				.addService(new AdvancedCalculatorImpl())
				//.addService(new StreamTesterImpl())
				//.keepAliveTime(12, TimeUnit.SECONDS)
				//.keepAliveTimeout(6, TimeUnit.SECONDS)
				.build()
				.start();


		logger.info("Server started, listening on " + port);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				// Use stderr here since the logger may have been reset by its JVM shutdown hook.
				System.err.println("*** shutting down gRPC server since JVM is shutting down");
				grpcServer.this.stop();
				System.err.println("*** server shut down");
			}
		});
	}

	private void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon threads.
	 */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	/**
	 * Main launches the server from the command line.
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		final grpcServer server = new grpcServer();
		server.start();
		server.blockUntilShutdown();
	}

}
