# Java-RMI
RMI Notes

#### Java RMI Note
> RMI stands for **Remote Method Invocation**. It is a mechanism that **allows an object residing in one system (JVM) to access/invoke an object running on another JVM**.

> RMI is used to *build distributed applications*; it provides remote communication between Java programs. It is provided in the package java.rmi.

# Architecture
we write two program **server program** (jun server ma basxa) and **client program** (jun client ma basxa) for RMI Application

> Inside the server program, a ``remote object is created`` and ``reference of that object is made available for the client`` (using the registry).


> The client program ``requests`` the remote objects on the server and tries to ``invoke`` its methods.





