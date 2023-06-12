# Java-RMI
RMI Notes

#### Java RMI Note
> RMI stands for **Remote Method Invocation**. It is a mechanism that **allows an object residing in one system (JVM) to access/invoke an object running on another JVM**.

> RMI is used to *build distributed applications*; it provides remote communication between Java programs. It is provided in the package java.rmi.

# Architecture
we write two program **server program** (jun server ma basxa) and **client program** (jun client ma basxa) for RMI Application

> Inside the server program, a ``remote object is created`` and ``reference of that object is made available for the client`` (using the registry).


> The client program ``requests`` the remote objects on the server and tries to ``invoke`` its methods.

## Architecture of RMI Application

<p align="center">
  <img src="/Diagrams/rmi_architecture.jpg" alt="Architecture of RMI Application">
</p>

> * **Transport Layer** - This layer connects the client and the server. It manages the existing connection and also sets up new connections.
> * **Stub** - A stub is a representation `(proxy)` of the remote object at client. It resides in the client system; it acts as a gateway for the client program.
> * **Skeleton** - This is the object which resides on the server side. stub communicates with this skeleton to pass request to the remote object.
> * **RRL(Remote Reference Layer)** - It is the layer which manages the references made by the client to the remote object.

# RMI Application Working

> * When the client makes a `call to the remote object`, it is `received by the stub` which eventually `passes this request to the RRL`.
> * When the client-side `RRL receives the request`, it `invokes a method called invoke() of the object remoteRef`. It `passes` the `request` to the `RRL on the server side`.
> * The `RRL on the server side passes the request to the Skeleton (proxy on the server)` which finally `invokes the required object on the server`.
> * The `result` is `passed` all the way back `to the client`.

# Marshalling and Unmarshalling
> When a `client` wants to `invoke` a `method on a remote object`, the `parameters for that method need to be sent over the network to the server where the object resides`. However, the `parameters cannot be directly sent` as they are because `they exist in the client's memory` and `the server cannot access that memory directly.`

> To overcome this, the `parameters are bundled together into a message.` If the `parameters are of primitive types (e.g., integers, booleans)`, they `can be put together as-is`, and a `header is attached to indicate the type and order of the parameters.`
However, if the `parameters are objects (instances of classes)`, they `need to be serialized before sending them over the network`. Serialization is the `process of converting an object into a format that can be easily transmitted or stored.` During serialization, the `object's state is converted into a byte stream that represents the object's data and structure`.


> The serialized objects, along with the headers for primitive parameters, are then sent over the network to the server.


> At the server side, the `packed parameters are received` and `need to be reconstructed into their original form`so that the method can be invoked with the correct arguments. This process is known as unmarshalling.


> Unmarshalling involves `extracting the headers for primitive parameters and interpreting them to determine the type and order of the parameters.` For objects, the serialized byte stream is deserialized, meaning it is converted back into an object with its original state and structure.


> Once the parameters have been unmarshalled, the server can then invoke the required method on the remote object using the extracted parameters.


> In summary, `marshalling is the process of packaging and, if necessary, serializing parameters into a format suitable for transmission over the network.` `Unmarshalling is the reverse process of extracting and reconstructing the parameters at the receiving end before invoking the desired method.` These processes allow for communication between clients and servers in remote method invocation scenarios.



# RMI Registry

<p align="center">
  <img src="/Diagrams/registry.jpg">
</p>

> RMI registry is a namespace on which all server objects are placed. Each time the server creates an object, it registers this object with the RMIregistry (using bind() or reBind() methods). These are registered using a unique name known as bind name.

> To invoke a remote object, the client needs a reference of that object. At that time, the client fetches the object from the registry using its bind name (using lookup() method).

# Goals of RMI
> * To minimize the complexity of the application.
> * To preserve type safety.
>> Type safety is a concept in programming languages that ensures type correctness and prevents certain types of runtime errors. It refers to the ability of a programming language to detect and prevent type-related errors during the compilation or interpretation process rather than allowing them to occur at runtime.
> * Distributed garbage collection.
> * Minimize the difference between working with local and remote objects.



