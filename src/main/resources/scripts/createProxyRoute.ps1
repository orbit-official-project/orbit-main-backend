
# ./createProxyRoutes.ps1 [name] [pass] [save_loc]

$fullPathIncFileName    = $MyInvocation.MyCommand.Definition
$currentScriptName      = $MyInvocation.MyCommand.Name
$currentExecutingPath   = $fullPathIncFileName.Replace($currentScriptName, "")

$serverName = $args[0] + '.orbitx.kr'
$pass       = $args[1]
$savedLoc   = $args[2]

$savedName  = $serverName + '.conf'
$conf_loc   = $currentExecutingPath + './default.conf'
$fullpath   = $savedLoc + '/' + $savedName

$replace=get-content $conf_loc
$replace -creplace '@name', $serverName -creplace '@host', $pass >> $fullpath