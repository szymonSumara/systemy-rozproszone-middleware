// package: services
// file: services.proto

/* tslint:disable */
/* eslint-disable */

import * as jspb from "google-protobuf";

export class String extends jspb.Message { 
    getValue(): string;
    setValue(value: string): String;

    serializeBinary(): Uint8Array;
    toObject(includeInstance?: boolean): String.AsObject;
    static toObject(includeInstance: boolean, msg: String): String.AsObject;
    static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
    static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
    static serializeBinaryToWriter(message: String, writer: jspb.BinaryWriter): void;
    static deserializeBinary(bytes: Uint8Array): String;
    static deserializeBinaryFromReader(message: String, reader: jspb.BinaryReader): String;
}

export namespace String {
    export type AsObject = {
        value: string,
    }
}
