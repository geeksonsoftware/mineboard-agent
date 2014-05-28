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
             "name":"Miner1",
             "type":"BFGMiner",
             "ip":"127.0.0.1",
             "port":4028
          },
          {
             "name":"Miner2",
             "type":"CGMINER",
             "ip":"127.0.0.2",
             "port":4028
          }
       ]
    }

The config is structure the following way:

 - `dashboardId` is the unique id of your dashboard on [mineboard.io][1], you can find out which is your by looking at the URL of your dashboard: https://mineboard.io/#/dashboard?id= **538394a0a38396ca08000001**
 - `intervalSeconds` specify how many seconds interval between each update
 - `miners` is an array containing object structured this way (**all fields are mandatory**)
  - `name` specify the name for the miner, this will be used as title in your dashboard widgets
  - `type` specify the kind of mining software is running, currently supported values are: `BFGMiner`, `CGMINER`
  - `ip` specify the IP of the miner
  - `port` specify the port where the mining software is exposing the API

You can assign as many miners as you want!

----------

Install
=======


Linux
-----

Create a directory that will contains the mineboard-agent files (i.e. /opt/mineboard-agent/)
   
`mkdir /opt/mineboard-agent`

Download the last [released jar file][2] to this directory
   
`wget https://github.com/geeksonsoftware/mineboard-agent/releases/download/0.0.1/mineboard-agent-0.0.1-SNAPSHOT.jar /opt/mineboard-agent/mineboard-agent.jar`

Configure your miners through the config.js file (see Section **Configuration**)

You can now run the agent by:

`# java -jar mineboard-agent.jar`

If you prefer you can use the deamon script available under [/deploy/linux/mineboard-agent-svc][3]:
* copy it to your /etc/init.d folder.
* Open with your preferred editor and change the `PATH_TO_JAR` and `AGENT_NAME` variable to match where the jar is located and the jar filename
* Just run like a normal service by issuing `$ sudo service mineboard-agent start`


Windows
-------

 - Coming soon
----------


  [1]: https://mineboard.io
  [2]: https://github.com/geeksonsoftware/mineboard-agent/releases
  [3]: https://raw.githubusercontent.com/geeksonsoftware/mineboard-agent/master/deploy/linux/mineboard-agent-svc