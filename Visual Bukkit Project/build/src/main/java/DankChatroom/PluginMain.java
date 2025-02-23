package DankChatroom;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

@SuppressWarnings({"unchecked", "rawtypes"})
public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	public static Map<String, Object> globalVariables = new HashMap<>();
	public static final java.util.regex.Pattern HEX_PATTERN = java.util.regex.Pattern
			.compile("#([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])");

	public static PluginMain getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
		try {
			org.bukkit.Bukkit.getConsoleSender()
					.sendMessage(ChatColor.translateAlternateColorCodes('&', PluginMain.HEX_PATTERN.matcher(
							"\n\n\n&l&c     888                   888                                             \n&l&c     888                   888           s i r &f.&c d a n k &f'&c s               \n&l&c     888                   888                                             \n&l&c .d88888  8888b.  88888b.  888  888 888  888  888  8888b.  888d888 .d88b.  \n&l&cd88\" 888     \"88b 888 \"88b 888 .88P 888  888  888     \"88b 888P\"  d8P  Y8b \n&l&c888  888 .d888888 888  888 888888K  888  888  888 .d888888 888    88888888 \n&l&cY88b 888 888  888 888  888 888 \"88b Y88b 888 d88P 888  888 888    Y8b.     \n&l&c \"Y88888 \"Y888888 888  888 888  888  \"Y8888888P\"  \"Y888888 888     \"Y8888  \n\n \n ")
							.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
			PluginMain.globalVariables.put("logger", org.bukkit.Bukkit.getLogger());
			PluginMain.globalVariables.put("username", ((Object) null));
			PluginMain.globalVariables.put("socket", ((Object) null));
			PluginMain.procedure("pSetUUID", Collections.emptyList());
			if (PluginMain.resolve_boolean(PluginMain.function("GetConfigValue", List.of("bStats")))) {
				PluginMain.procedure("print", List.of("bStats: Enabled"));
				PluginMain.procedure("pbStats", Collections.emptyList());
			} else {
				PluginMain.procedure("print", List.of("bStats: Disabled"));
			}
			if (PluginMain.resolve_boolean(PluginMain.function("GetConfigValue", List.of("autoConnect")))) {
				PluginMain.procedure("print", List.of("Auto-Connect: Enabled"));
				new org.bukkit.scheduler.BukkitRunnable() {
					public void run() {
						try {
							PluginMain.procedure("pLogin", Collections.emptyList());
							PluginMain.procedure("pConnect", Collections.emptyList());
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}.runTaskLaterAsynchronously(PluginMain.getInstance(), ((long) 0));
			} else {
				PluginMain.procedure("print", List.of("Auto-Connect: Disabled"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("chatroom-users")) {
			try {
				if (PluginMain.resolve_boolean(PluginMain.function("CheckConnected", Collections.emptyList()))) {
					PluginMain.procedure("pSend", List.of("/users"));
				} else {
					commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							PluginMain.HEX_PATTERN.matcher(
									"&8[&cdank&8.&cchatroom&8] &cChatroom disconnected&8! &cUse &6/chatroom-connect")
									.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("chatroom-username")) {
			try {
				if (!(PluginMain.globalVariables.get("username") == null)) {
					commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							PluginMain.HEX_PATTERN
									.matcher(("&8[&adank&8.&achatroom&8] &aServer username is &a&l"
											+ String.valueOf(PluginMain.globalVariables.get("username"))))
									.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
				} else {
					commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							PluginMain.HEX_PATTERN.matcher(
									"&8[&cdank&8.&cchatroom&8] &cServer is not authenticated&8! &cUse &6/chatroom-login")
									.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("chatroom-login")) {
			try {
				if ((PluginMain.globalVariables.get("username") == null)) {
					if (!(PluginMain.globalVariables.get("uuid") == null)) {
						commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								PluginMain.HEX_PATTERN.matcher("&8[&adank&8.&achatroom&8] &aAuthenticating...")
										.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
						new org.bukkit.scheduler.BukkitRunnable() {
							public void run() {
								try {
									PluginMain.procedure("pLogin", Collections.emptyList());
									if (!(PluginMain.globalVariables.get("username") == null)) {
										commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
												PluginMain.HEX_PATTERN
														.matcher(("&8[&adank&8.&achatroom&8] &aServer username is &a&l"
																+ String.valueOf(
																		PluginMain.globalVariables.get("username"))))
														.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
									} else {
										commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
												PluginMain.HEX_PATTERN.matcher(
														"&8[&cdank&8.&cchatroom&8] &cFailed&8! &cCheck console&8!")
														.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
									}
								} catch (Exception ex) {
									ex.printStackTrace();
								}
							}
						}.runTaskLaterAsynchronously(PluginMain.getInstance(), ((long) 0));
					} else {
						commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								PluginMain.HEX_PATTERN.matcher(
										"&8[&cdank&8.&cchatroom&8] &cHWID was not grabbed&8! &cReport this issue&8!")
										.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
					}
				} else {
					commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							PluginMain.HEX_PATTERN.matcher("&8[&adank&8.&achatroom&8] &aAlready authenticated&8!")
									.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("chatroom-disconnect")) {
			try {
				if (PluginMain.resolve_boolean(PluginMain.function("CheckConnected", Collections.emptyList()))) {
					PluginMain.procedure("pDisconnect", Collections.emptyList());
					commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							PluginMain.HEX_PATTERN.matcher("&8[&adank&8.&achatroom&8] &aDisconnected&8!")
									.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
				} else {
					commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							PluginMain.HEX_PATTERN.matcher("&8[&adank&8.&achatroom&8] &aAlready disconnected&8!")
									.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("chatroom-connect")) {
			try {
				if (!PluginMain.resolve_boolean(PluginMain.function("CheckConnected", Collections.emptyList()))) {
					if (!(PluginMain.globalVariables.get("username") == null)) {
						if (!(PluginMain.globalVariables.get("uuid") == null)) {
							commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									PluginMain.HEX_PATTERN.matcher("&8[&adank&8.&achatroom&8] &aConnecting...")
											.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
							PluginMain.procedure("pConnect", Collections.emptyList());
							new org.bukkit.scheduler.BukkitRunnable() {
								public void run() {
									try {
										if (PluginMain.resolve_boolean(
												PluginMain.function("CheckConnected", Collections.emptyList()))) {
											commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
													PluginMain.HEX_PATTERN
															.matcher("&8[&adank&8.&achatroom&8] &aConnected&8!")
															.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
										} else {
											commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
													PluginMain.HEX_PATTERN.matcher(
															"&8[&cdank&8.&cchatroom&8] &cFailed&8! &cCheck console&8!")
															.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
										}
									} catch (Exception ex) {
										ex.printStackTrace();
									}
								}
							}.runTaskLaterAsynchronously(PluginMain.getInstance(), ((long) 200));
						} else {
							commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									PluginMain.HEX_PATTERN.matcher(
											"&8[&cdank&8.&cchatroom&8] &cHWID was not grabbed&8! &cReport this issue&8!")
											.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
						}
					} else {
						commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								PluginMain.HEX_PATTERN.matcher(
										"&8[&cdank&8.&cchatroom&8] &cServer is not authenticated&8! &cUse &6/chatroom-login")
										.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
					}
				} else {
					commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							PluginMain.HEX_PATTERN.matcher("&8[&adank&8.&achatroom&8] &aAlready connected&8!")
									.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender commandSender, Command command, String alias,
			String[] commandArgs) {
		return null;
	}

	public static void procedure(String procedure, List args) throws Exception {
		if (procedure.equalsIgnoreCase("pSetUUID")) {
			Object $c6a2108d16db1ce85e9a3a3c1bc36082 = null;
			Object $1d671f62de079de3faaf11574e8d3e9a = null;
			Object $4f9069d342ae7862a68efa34d5f02110 = null;
			try {
				PluginMain.globalVariables.put("uuid", ((Object) null));
				if (java.lang.System.getProperty("os.name").toLowerCase()
						.contains(PluginMain.resolve_object("win", java.lang.CharSequence.class))) {
					$1d671f62de079de3faaf11574e8d3e9a = "wmic csproduct get uuid";
				} else {
					$1d671f62de079de3faaf11574e8d3e9a = "sudo dmidecode -s system-uuid";
				}
				$4f9069d342ae7862a68efa34d5f02110 = new java.io.BufferedReader(PluginMain.resolve_object(
						new java.io.InputStreamReader(java.lang.Runtime.getRuntime()
								.exec(String.valueOf($1d671f62de079de3faaf11574e8d3e9a)).getInputStream()),
						java.io.Reader.class));
				while (true) {
					$c6a2108d16db1ce85e9a3a3c1bc36082 = PluginMain
							.resolve_object($4f9069d342ae7862a68efa34d5f02110, java.io.BufferedReader.class).readLine();
					if (!($c6a2108d16db1ce85e9a3a3c1bc36082 == null)) {
						if (String.valueOf($c6a2108d16db1ce85e9a3a3c1bc36082)
								.contains(PluginMain.resolve_object("-", java.lang.CharSequence.class))) {
							PluginMain.globalVariables.put("uuid",
									String.valueOf($c6a2108d16db1ce85e9a3a3c1bc36082).trim());
							if (true)
								break;
						}
					} else {
						if (true)
							break;
					}
				}
				if (!(PluginMain.globalVariables.get("uuid") == null)) {
					PluginMain.procedure("print", List.of("Grabbed HWID"));
				} else {
					PluginMain.procedure("print", List.of("HWID was not grabbed (report this issue)"));
				}
			} catch (Exception $executionException1) {
				PluginMain.procedure("print", List.of("HWID was not grabbed (report this issue)"));
			}
			return;
		}
		if (procedure.equalsIgnoreCase("pSend")) {
			PluginMain.resolve_object(PluginMain.globalVariables.get("socket"), io.socket.client.Socket.class)
					.send(PluginMain.resolve_object(PluginMain.function("CompressString", List.of(args.get(0))),
							byte[].class));
			return;
		}
		if (procedure.equalsIgnoreCase("print")) {
			for (Object $FINAL_loopValue1 : PluginMain.resolve_object(args, java.lang.Iterable.class)) {
				PluginMain.resolve_object(PluginMain.globalVariables.get("logger"), java.util.logging.Logger.class)
						.info(("[dank.chatroom] " + String.valueOf($FINAL_loopValue1)));
			}
			return;
		}
		if (procedure.equalsIgnoreCase("pLogin")) {
			Object $fcdab816bcc22e60d0ecfeaf8b8516a4 = null;
			PluginMain.procedure("print", List.of("Authenticating..."));
			if (!(PluginMain.globalVariables.get("uuid") == null)) {
				$fcdab816bcc22e60d0ecfeaf8b8516a4 = new java.net.URL("https://dankware.onrender.com/chatroom-login")
						.openConnection();
				PluginMain.resolve_object($fcdab816bcc22e60d0ecfeaf8b8516a4, java.net.HttpURLConnection.class)
						.setRequestMethod("POST");
				PluginMain.resolve_object($fcdab816bcc22e60d0ecfeaf8b8516a4, java.net.HttpURLConnection.class)
						.setRequestProperty("User-Agent", "dank.plugin");
				PluginMain.resolve_object($fcdab816bcc22e60d0ecfeaf8b8516a4, java.net.HttpURLConnection.class)
						.setRequestProperty("Content-Encoding", "deflate");
				PluginMain.resolve_object($fcdab816bcc22e60d0ecfeaf8b8516a4, java.net.HttpURLConnection.class)
						.setRequestProperty("Content-Type", "application/json");
				PluginMain.resolve_object($fcdab816bcc22e60d0ecfeaf8b8516a4, java.net.HttpURLConnection.class)
						.setDoOutput(true);
				PluginMain
						.resolve_object(
								PluginMain.resolve_object($fcdab816bcc22e60d0ecfeaf8b8516a4,
										java.net.HttpURLConnection.class).getOutputStream(),
								java.io.ByteArrayOutputStream.class)
						.write(PluginMain.resolve_object(PluginMain.function("CompressString", List
								.of(("{\"uuid\":\"" + String.valueOf(PluginMain.globalVariables.get("uuid")) + "\"}"))),
								byte[].class));
				PluginMain.globalVariables.put("username",
						new java.lang.String(PluginMain
								.resolve_object($fcdab816bcc22e60d0ecfeaf8b8516a4, java.net.HttpURLConnection.class)
								.getInputStream().readAllBytes()));
				PluginMain.procedure("print",
						List.of(("Username: " + String.valueOf(PluginMain.globalVariables.get("username")))));
			} else {
				PluginMain.procedure("print", List.of("HWID was not grabbed"));
			}
			return;
		}
		if (procedure.equalsIgnoreCase("pDisconnect")) {
			PluginMain.resolve_object(PluginMain.globalVariables.get("socket"), io.socket.client.Socket.class)
					.disconnect();
			PluginMain.resolve_object(PluginMain.globalVariables.get("socket"), io.socket.client.Socket.class).close();
			PluginMain.globalVariables.put("socket", ((Object) null));
			return;
		}
		if (procedure.equalsIgnoreCase("pConnect")) {
			Object $3d8ad831c2827787faf45efd54a15341 = null;
			if (!(PluginMain.globalVariables.get("username") == null)) {
				try {
					PluginMain.procedure("print", List.of("Connecting... "));
					$3d8ad831c2827787faf45efd54a15341 = io.socket.client.SocketOptionBuilder.builder()
							.setReconnection(
									false)
							.setTimeout(((long) 10000))
							.setExtraHeaders(PluginMain.resolve_object(
									PluginMain.newHashMap("UUID", List.of(PluginMain.globalVariables.get("uuid")),
											"User-Agent", List.of("dank.plugin")),
									java.util.Map.class))
							.build();
					PluginMain.globalVariables.put("socket",
							io.socket.client.IO.socket(java.net.URI.create("https://dankware.onrender.com"),
									PluginMain.resolve_object($3d8ad831c2827787faf45efd54a15341,
											io.socket.client.IO.Options.class)));
					PluginMain.resolve_object(PluginMain.globalVariables.get("socket"), io.socket.client.Socket.class)
							.on(io.socket.client.Socket.EVENT_CONNECT, Args -> {
								try {
									System.out.println("Connected!");
								} catch (Exception e) {
									e.printStackTrace();
								}
							});
					PluginMain.resolve_object(PluginMain.globalVariables.get("socket"), io.socket.client.Socket.class)
							.on("message", Args -> {
								if (Args.length > 0 && Args[Args.length - 1] instanceof byte[]) {
									try {
										java.util.zip.Inflater inflater = new java.util.zip.Inflater();
										inflater.setInput((byte[]) Args[Args.length - 1]);
										byte[] buffer = new byte[1024];
										StringBuilder result = new StringBuilder();
										while (!inflater.finished()) {
											int decompressedLength = inflater.inflate(buffer);
											result.append(new String(buffer, 0, decompressedLength, "UTF-8"));
										}
										inflater.end();
										String coloredMessage = ChatColor.translateAlternateColorCodes('&',
												PluginMain.HEX_PATTERN
														.matcher(String.valueOf(PluginMain.function("ColorMessage",
																List.of(result.toString()))))
														.replaceAll("&x&$1&$2&$3&$4&$5&$6"));
										org.bukkit.Bukkit.broadcastMessage(coloredMessage);
									} catch (Exception e) {
										e.printStackTrace();
									}
								} else {
									System.out
											.println("The last element in Args is not a byte array or Args is empty.");
								}
							});
					PluginMain.resolve_object(PluginMain.globalVariables.get("socket"), io.socket.client.Socket.class)
							.connect();
				} catch (Exception $executionException1) {
					$executionException1.printStackTrace();
				}
			} else {
				PluginMain.procedure("print", List.of("Use /chatroom-login before trying to connect"));
			}
			return;
		}
		if (procedure.equalsIgnoreCase("pbStats")) {
			Object $ce52385f60f457bca3bc2a32c68e2fce = null;
			try {
				java.lang.System.setProperty("bstats.relocatecheck", "false");
				$ce52385f60f457bca3bc2a32c68e2fce = new org.bstats.bukkit.Metrics(
						PluginMain.resolve_object(PluginMain.getInstance(), org.bukkit.plugin.Plugin.class), 19689);
			} catch (Exception $executionException1) {
				PluginMain.procedure("print", List.of("bStats Integration: Failed"));
				$executionException1.printStackTrace();
			}
			return;
		}
	}

	public static Object function(String function, List args) throws Exception {
		if (function.equalsIgnoreCase("GetConfigValue")) {
			if (true)
				return PluginMain.getInstance().getConfig().get(String.valueOf(args.get(0)));
			return null;
		}
		if (function.equalsIgnoreCase("CompressString")) {
			Object $3983d6bb2f0a45b638461bc99138f22f = null;
			Object $e603c3bfc26b739ab628d398aa15df1c = null;
			Object $d5d9e1e97e2967d7b024eba4efefd945 = null;
			$e603c3bfc26b739ab628d398aa15df1c = new java.util.zip.Deflater();
			PluginMain.resolve_object($e603c3bfc26b739ab628d398aa15df1c, java.util.zip.Deflater.class)
					.setInput(String.valueOf(args.get(0)).getBytes());
			PluginMain.resolve_object($e603c3bfc26b739ab628d398aa15df1c, java.util.zip.Deflater.class).finish();
			$d5d9e1e97e2967d7b024eba4efefd945 = new java.io.ByteArrayOutputStream(
					String.valueOf(args.get(0)).getBytes().length);
			$3983d6bb2f0a45b638461bc99138f22f = new byte[1024];
			while (!PluginMain.resolve_object($e603c3bfc26b739ab628d398aa15df1c, java.util.zip.Deflater.class)
					.finished()) {
				try {
					PluginMain.resolve_object($d5d9e1e97e2967d7b024eba4efefd945, java.io.ByteArrayOutputStream.class)
							.write(PluginMain.resolve_object($3983d6bb2f0a45b638461bc99138f22f, byte[].class), 0,
									PluginMain
											.resolve_object($e603c3bfc26b739ab628d398aa15df1c,
													java.util.zip.Deflater.class)
											.deflate(PluginMain.resolve_object($3983d6bb2f0a45b638461bc99138f22f,
													byte[].class)));
				} catch (Exception $executionException1) {
					$executionException1.printStackTrace();
					if (true)
						break;
				}
			}
			PluginMain.resolve_object($e603c3bfc26b739ab628d398aa15df1c, java.util.zip.Deflater.class).end();
			if (true)
				return PluginMain.resolve_object($d5d9e1e97e2967d7b024eba4efefd945, java.io.ByteArrayOutputStream.class)
						.toByteArray();
			return null;
		}
		if (function.equalsIgnoreCase("ColorMessage")) {
			Object $a15f6804744220b583ab9c3b5e950025 = null;
			$a15f6804744220b583ab9c3b5e950025 = args.get(0);
			if ((String.valueOf($a15f6804744220b583ab9c3b5e950025).startsWith("[dank.server]")
					&& String.valueOf($a15f6804744220b583ab9c3b5e950025).endsWith(" joined!"))) {
				if (true)
					return String.valueOf($a15f6804744220b583ab9c3b5e950025).replaceFirst(
							java.util.regex.Pattern.quote("[dank.server] -"),
							"&8&l[&adank&8.&aserver&8&l][&a+&8&l]&a&l");
			} else if ((String.valueOf($a15f6804744220b583ab9c3b5e950025).startsWith("[dank.server]")
					&& String.valueOf($a15f6804744220b583ab9c3b5e950025).endsWith(" left!"))) {
				if (true)
					return String.valueOf($a15f6804744220b583ab9c3b5e950025).replaceFirst(
							java.util.regex.Pattern.quote("[dank.server] -"),
							"&8&l[&cdank&8.&cserver&8&l][&c-&8&l]&c&l");
			} else if (String.valueOf($a15f6804744220b583ab9c3b5e950025).startsWith("[dank.server]")) {
				if (true)
					return String.valueOf($a15f6804744220b583ab9c3b5e950025)
							.replaceFirst(java.util.regex.Pattern.quote("[dank.server]"), "&8[&cdank&8.&cserver&8]&b");
			} else if (String.valueOf($a15f6804744220b583ab9c3b5e950025).startsWith("[dank.server-error]")) {
				if (true)
					return String.valueOf($a15f6804744220b583ab9c3b5e950025).replaceFirst(
							java.util.regex.Pattern.quote("[dank.server-error]"), "&8[&4dank&8.&4server&8]&4");
			} else if (String.valueOf($a15f6804744220b583ab9c3b5e950025).startsWith("[SirDank]")) {
				if (true)
					return String.valueOf($a15f6804744220b583ab9c3b5e950025)
							.replaceFirst(java.util.regex.Pattern.quote("[SirDank] -"), "&8[&cSirDank&8] \u27A4&b");
			}
			if (true)
				return String.valueOf($a15f6804744220b583ab9c3b5e950025).replaceFirst("[", "&8[&a").replaceFirst("] -",
						"&8] \u27A4&b");
			return null;
		}
		if (function.equalsIgnoreCase("CheckConnected")) {
			if (true)
				return PluginMain.resolve_object(((!(PluginMain.globalVariables.get("socket") == null)) && PluginMain
						.resolve_object(PluginMain.globalVariables.get("socket"), io.socket.client.Socket.class)
						.connected()), java.lang.Object.class);
			return null;
		}
		return null;
	}

	public static char resolve_char(Object o) {
		return o instanceof String s ? s.charAt(0) : (char) o;
	}

	public static boolean resolve_boolean(Object o) {
		return (boolean) o;
	}

	public static byte resolve_byte(Object o) {
		return ((Number) o).byteValue();
	}

	public static short resolve_short(Object o) {
		return ((Number) o).shortValue();
	}

	public static int resolve_int(Object o) {
		return ((Number) o).intValue();
	}

	public static long resolve_long(Object o) {
		return ((Number) o).longValue();
	}

	public static float resolve_float(Object o) {
		return ((Number) o).floatValue();
	}

	public static double resolve_double(Object o) {
		return ((Number) o).doubleValue();
	}

	public static <T> T resolve_object(Object from, Class<T> to) {
		if (from == null) {
			return null;
		}
		if (to.isAssignableFrom(from.getClass())) {
			return to.cast(from);
		}
		if (from instanceof Number num && Number.class.isAssignableFrom(to)) {
			return to.cast(num.doubleValue());
		}
		if (from instanceof Collection collection && to.isArray()) {
			Object arr = Array.newInstance(to.componentType(), collection.size());
			int i = 0;
			for (Object obj : collection) {
				Array.set(arr, i++, obj);
			}
			return (T) arr;
		}
		if (from instanceof Collection collection && Collection.class.isAssignableFrom(to)) {
			Collection newCollection = getCollectionInstance(to);
			newCollection.addAll(collection);
			return (T) newCollection;
		}
		if (from.getClass().isArray() && Collection.class.isAssignableFrom(to)) {
			Collection newCollection = getCollectionInstance(to);
			for (int i = 0; i < Array.getLength(from); i++) {
				newCollection.add(Array.get(from, i));
			}
			return (T) newCollection;
		}
		return to.cast(from);
	}

	private static Collection getCollectionInstance(Class<?> type) {
		try {
			return (Collection) type.getConstructor().newInstance();
		} catch (Exception e) {
			if (List.class.isAssignableFrom(type)) {
				return new ArrayList<>();
			}
			if (Set.class.isAssignableFrom(type)) {
				return new HashSet<>();
			}
			if (Queue.class.isAssignableFrom(type)) {
				return new ArrayDeque<>();
			}
			return null;
		}
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void $event_uzfo6TH55jRW153U(org.bukkit.event.player.AsyncPlayerChatEvent event) throws Exception {
		Object $a15f6804744220b583ab9c3b5e950025 = null;
		if (PluginMain.resolve_boolean(PluginMain.function("CheckConnected", Collections.emptyList()))) {
			$a15f6804744220b583ab9c3b5e950025 = ("[" + event.getPlayer().getName() + "] - " + event.getMessage());
			if ((((double) String.valueOf($a15f6804744220b583ab9c3b5e950025).length()) <= ((double) 200))) {
				PluginMain.procedure("pSend", List.of($a15f6804744220b583ab9c3b5e950025));
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void $event_AO9z1qNtiESp3P5O(org.bukkit.event.player.PlayerJoinEvent event) throws Exception {
		if (PluginMain.resolve_boolean(PluginMain.function("CheckConnected", Collections.emptyList()))) {
			PluginMain.procedure("pSend", List.of((event.getPlayer().getName() + " joined the server!")));
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void $event_cEJ7OjfNEHY3S56o(org.bukkit.event.player.PlayerQuitEvent event) throws Exception {
		if (PluginMain.resolve_boolean(PluginMain.function("CheckConnected", Collections.emptyList()))) {
			PluginMain.procedure("pSend", List.of((event.getPlayer().getName() + " left the server!")));
		}
	}

	public static HashMap newHashMap(Object... objects) {
		HashMap map = new HashMap();
		for (int i = 0; i < objects.length - 1; i += 2) {
			map.put(objects[i], objects[i + 1]);
		}
		return map;
	}
}