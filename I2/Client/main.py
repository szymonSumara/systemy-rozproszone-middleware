# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
import grpc

from grpc_reflection.v1alpha.proto_reflection_descriptor_database import ProtoReflectionDescriptorDatabase
from google.protobuf.descriptor_pool import DescriptorPool
from google.protobuf import reflection as _reflection
from google.protobuf import message as _message


def field_type_to_string(field_type):
    TYPE_BOOL = 8
    TYPE_BYTES = 12
    TYPE_DOUBLE = 1
    TYPE_ENUM = 14
    TYPE_FIXED32 = 7
    TYPE_FIXED64 = 6
    TYPE_FLOAT = 2
    TYPE_GROUP = 10
    TYPE_INT32 = 5
    TYPE_INT64 = 3
    TYPE_MESSAGE = 11
    TYPE_SFIXED32 = 15
    TYPE_SFIXED64 = 16
    TYPE_SINT32 = 17
    TYPE_SINT64 = 18
    TYPE_STRING = 9
    TYPE_UINT32 = 13
    TYPE_UINT64 = 4

    if field_type == TYPE_INT32:
        return "INT32"
    if field_type == TYPE_MESSAGE:
        return "TYPE_MESSAGE"

def field_label_to_string(field_type):
    LABEL_OPTIONAL = 1
    LABEL_REPEATED = 3
    LABEL_REQUIRED = 2

    if field_type == LABEL_OPTIONAL:
        return "LABEL_OPTIONAL"
    if field_type == LABEL_REPEATED:
        return "LABEL_REPEATED"
    if field_type == LABEL_REQUIRED:
        return "LABEL_REQUIRED"


def list_message_types(message):
    for field in message.DESCRIPTOR.fields:
        print(field.name, field_type_to_string(field.type), field_label_to_string(field.label))




if __name__ == '__main__':

    channel = grpc.insecure_channel("127.0.0.1:50051")
    reflection_db = ProtoReflectionDescriptorDatabase(channel)

    services = reflection_db.get_services()
    desc_pool = DescriptorPool(reflection_db)
    print(desc_pool)
    print(services)

    types = {}
    methods = {}

    service_desc = desc_pool.FindServiceByName(services[1])
    for method in service_desc.methods:

        if types.get(method.input_type.name) == None:
            types[method.input_type.name] = _reflection.GeneratedProtocolMessageType(method.input_type.name, (_message.Message,), {
                'DESCRIPTOR': method.input_type,
                '__module__': services[1].split('.')[0]
                # @@protoc_insertion_point(class_scope:calculator.ArithmeticOpResult)
            })

        if types.get(method.output_type.name) == None:
            types[method.output_type.name] = _reflection.GeneratedProtocolMessageType(method.output_type.name, (_message.Message,), {
                'DESCRIPTOR': method.output_type,
                '__module__': 'calculator'
                # @@protoc_insertion_point(class_scope:calculator.ArithmeticOpResult)
            })

        input_type = types[method.input_type.name]
        output_type = types[method.output_type.name]
        print(method.name, input_type, output_type)

        methods[method.name] = channel.unary_unary(
            '/' + services[1] + '/' + method.name,
            request_serializer=input_type.SerializeToString,
            response_deserializer=output_type.FromString,
        )

    print(types.items())
    print(methods.items())

    add_input_type = types['ArithmeticOpArguments']()


    list_message_types(add_input_type)

    add_input_type.arg1 = 14
    add_input_type.arg2 = 16



    print(methods['Add'](add_input_type))

    subtract_input_type = types['ArithmeticOpArguments']()

    subtract_input_type.arg1 = 23
    subtract_input_type.arg2 = 1

    print(methods['Subtract'](subtract_input_type))


    mull_input_type = types['MullRequest']()
    mull_input_type.res.extend([1, 2, 3, 4, 5])
    list_message_types(mull_input_type)

    print(methods['Mull'](mull_input_type))




