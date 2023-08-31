package vb.$dankchatroom;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	public static Object GLOBAL_9ce148715491d15c729aff6847d37f60;
	public static Object GLOBAL_65e48c28264992f0f46da7786376f6c3;
	public static Object GLOBAL_54bc2ca21fe9f603fdf50a6cae5269ec;

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		try {
			new Metrics(PluginMain.getInstance(), ((int) (19689d)));
			PluginMain.procedure("chatroom_enabler", new ArrayList());
			((org.bukkit.command.CommandSender) (Object) ((org.bukkit.command.ConsoleCommandSender) org.bukkit.Bukkit
					.getConsoleSender())).sendMessage(ChatColor.translateAlternateColorCodes('&',
							"\n\n\n&l&c     888                   888                                             \n&l&c     888                   888           s i r &f.&c d a n k &f'&c s               \n&l&c     888                   888                                             \n&l&c .d88888  8888b.  88888b.  888  888 888  888  888  8888b.  888d888 .d88b.  \n&l&cd88\" 888     \"88b 888 \"88b 888 .88P 888  888  888     \"88b 888P\"  d8P  Y8b \n&l&c888  888 .d888888 888  888 888888K  888  888  888 .d888888 888    88888888 \n&l&cY88b 888 888  888 888  888 888 \"88b Y88b 888 d88P 888  888 888    Y8b.     \n&l&c \"Y88888 \"Y888888 888  888 888  888  \"Y8888888P\"  \"Y888888 888     \"Y8888  \n\n \n "));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {
		try {
			PluginMain.GLOBAL_9ce148715491d15c729aff6847d37f60 = ((java.lang.Object) (Object) false);
			PluginMain.getInstance().getLogger().info("Goodbye!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("chatroom-disconnect")) {
			try {
				if (PluginMain.checkEquals(GLOBAL_9ce148715491d15c729aff6847d37f60,
						((java.lang.Object) (Object) true))) {
					PluginMain.GLOBAL_9ce148715491d15c729aff6847d37f60 = ((java.lang.Object) (Object) false);
				} else {
					commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&6[&cdank&6.&cserver&6] \u27A4 &bYou are already disconnected&6!"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("chatroom-connect")) {
			try {
				if (PluginMain.checkEquals(GLOBAL_9ce148715491d15c729aff6847d37f60,
						((java.lang.Object) (Object) true))) {
					commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&6[&cdank&6.&cserver&6] \u27A4 &bYou are already connected&6!"));
				} else {
					PluginMain.procedure("chatroom_enabler", new ArrayList());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return true;
	}

	public static void procedure(String procedure, List procedureArgs) throws Exception {
		if (procedure.equalsIgnoreCase("chatroom_enabler")) {
			PluginMain.GLOBAL_54bc2ca21fe9f603fdf50a6cae5269ec = ((java.lang.Object) (Object) (0d));
			PluginMain.procedure("get_hwid", new ArrayList());
			if (PluginMain.checkEquals(GLOBAL_9ce148715491d15c729aff6847d37f60, ((java.lang.Object) (Object) true))) {
				try {
					PluginMain.procedure("chatroom_login", new ArrayList());
				} catch (Exception FDdPJBDGrSIbLPjt) {
					PluginMain.getInstance().getLogger().severe("Failed to login!");
					PluginMain.GLOBAL_9ce148715491d15c729aff6847d37f60 = ((java.lang.Object) (Object) false);
				}
				new org.bukkit.scheduler.BukkitRunnable() {
					public void run() {
						try {
							if (PluginMain.checkEquals(GLOBAL_9ce148715491d15c729aff6847d37f60,
									((java.lang.Object) (Object) true))) {
								try {
									PluginMain.procedure("chatroom_grabber", new ArrayList());
								} catch (Exception mkwXkLwgvwOjTLjs) {
									PluginMain.getInstance().getLogger().severe("Failed to get chat!");
									PluginMain.GLOBAL_9ce148715491d15c729aff6847d37f60 = ((java.lang.Object) (Object) false);
									cancel();
								}
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}.runTaskTimerAsynchronously(PluginMain.getInstance(), 0, ((long) (100d)));
			}
			return;
		}
		if (procedure.equalsIgnoreCase("chatroom_grabber")) {
			Object $bc7a3735449b83083cc97352e7e92f2a = null;
			Object $4d6c6afd73ebb562dab16d7cf5012aa8 = null;
			Object $570d81f9b3d3f6e1f3987f1e608b57f7 = null;
			Object $b979d3536be72c6fde1bea3ac6314886 = null;
			$bc7a3735449b83083cc97352e7e92f2a = new ArrayList(Arrays.asList(
					(((("{\"uuid\":\"" + String.valueOf(GLOBAL_65e48c28264992f0f46da7786376f6c3)) + "\",\"msg_id\":\"")
							+ String.valueOf(GLOBAL_54bc2ca21fe9f603fdf50a6cae5269ec)) + "\"}")));
			$570d81f9b3d3f6e1f3987f1e608b57f7 = new ArrayList(Arrays.asList(PluginMain.function("send_request",
					new ArrayList(Arrays.asList("https://dank-site.onrender.com/chatroom", "GET", PluginMain
							.function("compress", ((java.util.List) (Object) $bc7a3735449b83083cc97352e7e92f2a)))))));
			$b979d3536be72c6fde1bea3ac6314886 = PluginMain.function("mapper", new ArrayList(Arrays.asList(
					PluginMain.function("decompress", ((java.util.List) (Object) $570d81f9b3d3f6e1f3987f1e608b57f7)))));
			$4d6c6afd73ebb562dab16d7cf5012aa8 = ((java.lang.Object) ((java.util.HashMap) (Object) $b979d3536be72c6fde1bea3ac6314886)
					.get("chat"));
			$4d6c6afd73ebb562dab16d7cf5012aa8 = PluginMain.createList(
					((java.lang.String) ((java.lang.String) String.valueOf($4d6c6afd73ebb562dab16d7cf5012aa8).replace(
							String.valueOf("["), String.valueOf(ChatColor.translateAlternateColorCodes('&', "&6[&c"))))
									.replace(String.valueOf("] >"),
											String.valueOf(
													ChatColor.translateAlternateColorCodes('&', "&6] \u27A4&b"))))
															.split("\\\\n", ((int) (25d))));
			if (!PluginMain.checkEquals($4d6c6afd73ebb562dab16d7cf5012aa8, new ArrayList(Arrays.asList("")))) {
				for (Object FINAL_loopValue1 : ((java.util.List) (Object) $4d6c6afd73ebb562dab16d7cf5012aa8)) {
					org.bukkit.Bukkit.broadcastMessage(String.valueOf(FINAL_loopValue1));
				}
				PluginMain.GLOBAL_54bc2ca21fe9f603fdf50a6cae5269ec = ((java.lang.Object) ((java.util.HashMap) (Object) $b979d3536be72c6fde1bea3ac6314886)
						.get("msg_id"));
			}
			return;
		}
		if (procedure.equalsIgnoreCase("chatroom_input")) {
			Object $bc7a3735449b83083cc97352e7e92f2a = null;
			Object $01903771aa49381d3482b07d777054c5 = null;
			$bc7a3735449b83083cc97352e7e92f2a = new ArrayList(Arrays.asList(
					(((("{\"uuid\":\"" + String.valueOf(GLOBAL_65e48c28264992f0f46da7786376f6c3)) + "\",\"msg\":\"")
							+ String.valueOf(((java.lang.Object) procedureArgs.get(((int) (0d)))))) + "\"}")));
			$01903771aa49381d3482b07d777054c5 = PluginMain.function("send_request", new ArrayList(Arrays.asList(
					"https://dank-site.onrender.com/chatroom", "POST",
					PluginMain.function("compress", ((java.util.List) (Object) $bc7a3735449b83083cc97352e7e92f2a)))));
			return;
		}
		if (procedure.equalsIgnoreCase("chatroom_login")) {
			Object $bc7a3735449b83083cc97352e7e92f2a = null;
			Object $01903771aa49381d3482b07d777054c5 = null;
			$bc7a3735449b83083cc97352e7e92f2a = new ArrayList(Arrays
					.asList((("{\"uuid\":\"" + String.valueOf(GLOBAL_65e48c28264992f0f46da7786376f6c3)) + "\"}")));
			$01903771aa49381d3482b07d777054c5 = PluginMain.function("send_request", new ArrayList(Arrays.asList(
					"https://dank-site.onrender.com/chatroom-login", "POST",
					PluginMain.function("compress", ((java.util.List) (Object) $bc7a3735449b83083cc97352e7e92f2a)))));
			return;
		}
		if (procedure.equalsIgnoreCase("get_hwid")) {
			try {
				String os = System.getProperty("os.name").toLowerCase();
				String command = (os.contains("win")) ? "wmic csproduct get uuid" : "dmidecode -s system-uuid";
				Process process = Runtime.getRuntime().exec(command);
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				StringBuilder uuidBuilder = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					uuidBuilder.append(line.trim());
				}
				PluginMain.GLOBAL_65e48c28264992f0f46da7786376f6c3 = uuidBuilder.toString().replace("UUID", "")
						.replace(":", "").trim();
				PluginMain.getInstance().getLogger()
						.info(("HWID: " + String.valueOf(GLOBAL_65e48c28264992f0f46da7786376f6c3)));
				PluginMain.GLOBAL_9ce148715491d15c729aff6847d37f60 = ((java.lang.Object) (Object) true);
			} catch (Exception rTgLsjbzaWMbvUnm) {
				PluginMain.getInstance().getLogger().severe("Failed to get HWID!");
				PluginMain.GLOBAL_9ce148715491d15c729aff6847d37f60 = ((java.lang.Object) (Object) false);
			}
			return;
		}
	}

	public static Object function(String function, List functionArgs) throws Exception {
		if (function.equalsIgnoreCase("mapper")) {
			try {
				String jsonData = (String) functionArgs.get(0);
				Map<String, String> responseMap = new HashMap<>();
				if (jsonData.startsWith("{") && jsonData.endsWith("}")) {
					jsonData = jsonData.substring(1, jsonData.length() - 1);
				}
				String[] keyValuePairs = jsonData.split(", ");
				for (String pair : keyValuePairs) {
					String[] parts = pair.split(": ", 2);
					if (parts.length == 2) {
						String key = parts[0].trim().replaceAll("\"", "");
						String value = parts[1].trim().replaceAll("\"", "");
						responseMap.put(key, value);
					}
				}
				return responseMap;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (function.equalsIgnoreCase("decompress")) {
			java.util.zip.Inflater inflater = new java.util.zip.Inflater();
			byte[] compressedData = (byte[]) functionArgs.get(0);
			inflater.setInput(compressedData);
			byte[] buffer = new byte[1024];
			StringBuilder result = new StringBuilder();
			try {
				while (!inflater.finished()) {
					int decompressedLength = inflater.inflate(buffer);
					result.append(new String(buffer, 0, decompressedLength, "UTF-8"));
				}
			} catch (UnsupportedEncodingException | java.util.zip.DataFormatException e) {
				e.printStackTrace();
			} finally {
				inflater.end();
			}
			return result.toString();
		}
		if (function.equalsIgnoreCase("send_request")) {
			try {
				byte[] jsonData = (byte[]) functionArgs.get(2);
				String urlString = (String) functionArgs.get(0);
				java.net.HttpURLConnection connection = (java.net.HttpURLConnection) new java.net.URL(urlString)
						.openConnection();
				connection.setRequestMethod("GET");
				connection.setRequestProperty("User-Agent", "dank.plugin");
				connection.setRequestProperty("Content-Encoding", "deflate");
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setDoOutput(true);
				OutputStream os = connection.getOutputStream();
				os.write(jsonData);
				os.flush();
				os.close();
				InputStream inputStream = connection.getInputStream();
				byte[] responseBytes = inputStream.readAllBytes();
				String responseMessage = connection.getResponseMessage();
				if (!"OK".equals(responseMessage)) {
					System.out.println("Response: " + responseMessage);
				}
				return responseBytes;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (function.equalsIgnoreCase("compress")) {
			try {
				byte[] inputBytes = ((String) functionArgs.get(0)).getBytes();
				java.util.zip.Deflater deflater = new java.util.zip.Deflater();
				deflater.setInput(inputBytes);
				deflater.finish();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(inputBytes.length);
				byte[] buffer = new byte[1024];
				while (!deflater.finished()) {
					int compressedLength = deflater.deflate(buffer);
					outputStream.write(buffer, 0, compressedLength);
				}
				deflater.end();
				return outputStream.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List createList(Object obj) {
		if (obj instanceof List) {
			return (List) obj;
		}
		List list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else if (obj instanceof Iterator) {
			((Iterator<?>) obj).forEachRemaining(list::add);
		} else {
			list.add(obj);
		}
		return list;
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

	public static PluginMain getInstance() {
		return instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void event1(org.bukkit.event.player.AsyncPlayerChatEvent event) throws Exception {
		if (PluginMain.checkEquals(GLOBAL_9ce148715491d15c729aff6847d37f60, ((java.lang.Object) (Object) true))) {
			try {
				PluginMain.procedure("chatroom_input", new ArrayList(Arrays.asList(((("["
						+ ((java.lang.String) ((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event
								.getPlayer())).getName()))
						+ "] > ") + ((java.lang.String) event.getMessage())))));
			} catch (Exception OxyMvgCgycnRzubF) {
				PluginMain.getInstance().getLogger().severe("Input Failed!");
			}
		}
	}

	public static boolean checkEquals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1 instanceof Number && o2 instanceof Number
				? ((Number) o1).doubleValue() == ((Number) o2).doubleValue()
				: o1.equals(o2);
	}
}
