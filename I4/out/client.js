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
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
const grpc = __importStar(require("grpc"));
const services = __importStar(require("../generated/services_grpc_pb"));
const services_pb_1 = require("../generated/services_pb");
function main() {
    return __awaiter(this, void 0, void 0, function* () {
        const target = 'localhost:8080';
        const a = new services.AClient(target, grpc.credentials.createInsecure());
        const b = new services.BClient(target, grpc.credentials.createInsecure());
        const c = new services.CClient(target, grpc.credentials.createInsecure());
        const callback = (err, res) => {
            if (err)
                return console.log(err);
            console.log(err, res.getValue());
        };
        const aMessage = new services_pb_1.String();
        aMessage.setValue("a call");
        const bMessage = new services_pb_1.String();
        bMessage.setValue("b call");
        const cMessage = new services_pb_1.String();
        cMessage.setValue("c call");
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
    });
}
main();
//# sourceMappingURL=client.js.map