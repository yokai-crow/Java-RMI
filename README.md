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
> * **Stub** - A stub is a representation (proxy) of the remote object at client. It resides in the client system; it acts as a gateway for the client program.
> * **Skeleton** - This is the object which resides on the server side. stub communicates with this skeleton to pass request to the remote object.
> * **RRL(Remote Reference Layer)** - It is the layer which manages the references made by the client to the remote object.

# RMI Application Working

> * When the client makes a `call to the remote object`, it is `received by the stub` which eventually `passes this request to the RRL`.
> * When the client-side `RRL receives the request`, it `invokes a method called invoke() of the object remoteRef`. It `passes` the `request` to the `RRL on the server side`.
> * The `RRL on the server side passes the request to the Skeleton (proxy on the server)` which finally `invokes the required object on the server`.
> * The `result` is `passed` all the way back `to the client`.

# Marshalling and Unmarshalling

# RMI Registry

# Goals of RMI
> * To minimize the complexity of the application.
> * To preserve type safety.
>> Type safety is a concept in programming languages that ensures type correctness and prevents certain types of runtime errors. It refers to the ability of a programming language to detect and prevent type-related errors during the compilation or interpretation process rather than allowing them to occur at runtime.
> * Distributed garbage collection.
> * Minimize the difference between working with local and remote objects.



