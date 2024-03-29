"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    Object.defineProperty(o, k2, { enumerable: true, get: function() { return m[k]; } });
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const grpc = __importStar(require("grpc"));
const services_grpc_pb_1 = require("../generated/services_grpc_pb");
const BServer_1 = __importDefault(require("./Servers/BServer"));
const CServer_1 = __importDefault(require("./Servers/CServer"));
function main() {
    var server = new grpc.Server();
    server.addService(services_grpc_pb_1.BService, new BServer_1.default());
    server.addService(services_grpc_pb_1.CService, new CServer_1.default());
    server.bindAsync('0.0.0.0:50052', grpc.ServerCredentials.createInsecure(), () => {
        server.start();
    });
}
main();
//# sourceMappingURL=serverBC.js.map