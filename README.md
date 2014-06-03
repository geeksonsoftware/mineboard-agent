[![Build Status](https://drone.io/github.com/geeksonsoftware/mineboard-agent/status.png)](https://drone.io/github.com/geeksonsoftware/mineboard-agent/latest)

Mineboard-agent
===============

Retrieve mining applications data and submit them to [mineboard.io][1]

Configuration
=============
In order for the agent to retrieve the data from your mining machines, you first have to create a **config.json** file on the same directory where the executable will be placed (i.e. /opt/mineboard-agent/).

Here is an example of config.json file content:

    {
       "dashboardId":"5374d26bbdfb284660000001",
       "intervalSeconds":60,
       "miners":[
          {
             "secret":"d32c62be-56df-df07-8adf-b5ae3fa65a8e",
             "type":"BFGMiner",
             "ip":"127.0.0.1",
             "port":4028
          },
          {
             "secret":"c12de052-f2ee-4cb9-a4d5-9d19a36e9a7b",
             "type":"CGMINER",
             "ip":"127.0.0.2",
             "port":4028
          }
       ]
    }

The config is structure the following way:

 - `dashboardId` is the unique id of your dashboard on mineboard.io, you can find out which is your by looking at the URL of your dashboard: https://mineboard.io/#/dashboard?id=**538394a0a38396ca08000001**
 - `intervalSeconds` specify how many seconds interval between each update
 - `miners` is an array containing object structured this way (**all fields are mandatory**)
  - `secret` unique identifier of the miner (you get this ID from [mineboard.io Widgets][2] -> + Miner Agent)
  - `type` specify the kind of mining software is running, currently supported values are: `BFGMiner`, `CGMINER`
  - `ip` specify the IP of the miner
  - `port` specify the port where the mining software is exposing the API

You can assign as many miners as you want!

Install
=======

Windows
-------

 - Coming soon

Linux
-----

**Install certificate to JVM certificate store**

To add certificate for mineboard.io to JVM certificate store you first need to locate the certificate store for the current java version:
`locate cacerts`

Download the certificate through openssl
`echo -n | openssl s_client -connect mineboard.io:443 | sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p' > /tmp/mineboard.cert`

Add the certificate /tmp/mineboard.cert to the keystore:
`sudo keytool -importcert -alias "mineboard" -file /tmp/mineboard.cert -keystore /usr/lib/jvm/java-8-oracle/jre/lib/security/cacerts -storepass changeit`

Where the keystore path should reflect the locate result for the current java version (`java -version` if you have doubts)

**Get the software running!**

 - Create a directory which will contains the mineboard-agent files (i.e. /opt/mineboard-agent/)
  `mkdir /opt/mineboard-agent`
 - Download the last [released jar file][3] to this directory
   `wget https://github.com/geeksonsoftware/mineboard-agent/releases/mineboard-agent.jar /opt/mineboard-agent/mineboard-agent.jar`
 - Configure your miners through the config.json file (see **Configuration** section above)

----------


  [1]: https://mineboard.io
  [2]: https://mineboard.io/#/widgets
  [3]: https://github.com/geeksonsoftware/mineboard-agent/releases