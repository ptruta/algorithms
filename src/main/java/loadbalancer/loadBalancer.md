## Problem Description

A developer created a web application that solves a very difficualt mathematical equation.
As the computational load of the incoming requests to the application server may be very heavy,
it was decided to scale the application using multiple servers to that mutiple requests can be handled simultaneously.
No two requests come at the exact same time, and they are assigned to the next server that is not busy.
Servers are allocated to requests in round robin fashion starting from the first server.
If a server is busy, it is skipped. If no server is free, then the request is dropped, i.e.,
not handled at all.

The servers have infinite computaional capacity, so each server can serve any incoming request.
At the end of the day, the developer takes down the busiest server that day for maintenance.
Determine which server did the most computaional work during the day.
If there is a tie for the most work, return the list of servers sorted in ascending order of server id.

```
Example:

There are k=3 servers and n=5 incoming requests.
The arrival times, arrivals = [1,2,3,4,5], and the load for each request, the duration that the server
will be occupied with the request, are load = [6,3,4,4,4].

Request Arrival Load Finish Server
1       1       6    6      1
2       2       3    4      2
3       3       4    6      3
4       4       4    7      2
5       5       4    8      dropped


All of the servers start out available. The first 3 requests are handled by the 3 servers in order.
When request 4 comes in, server 1 is busy, but server 2 is available and serves the request.
Request 5 cannot be served so it is dropped.
Server 1 handles a load of 6, and server 2 handles a load of 3 + 4 = 7. Server 2 was the busiest server.

Function Description:
Complete the function loadBalancing. The function must return an array of integers that denotes the id numbers of the servers that did the most
work in ascending order.

loadBalancing has the following parameter(s):
k = an integer, the number of web servers,
arrival = an array of integers, the arrival times of each request.
load = an array of n integers the load of eahc request, i.e, the time to server each request.

Contraints:
- 1 <=n <= 10^5
- 1 <= k <= 10^5
- 1 <= arrival[i] <= 10^9
- 1 <= load[i] <= 10^9.
```

Source: https://www.youtube.com/watch?v=-3jdCHQu06M