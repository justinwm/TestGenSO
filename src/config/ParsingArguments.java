package config;

public class ParsingArguments {
	
	public static void parsingArguments(String[] args) {
//		System.out.println(args.length);
		String pro = config.Config.targetLib;
		int begin = config.Config.seedBegin;
		int end = config.Config.seedEnd;
		
		if (args.length == 0) {
			showHelp();
		} else {
			int i = 0;
			while (i < args.length - 1) {
				if (args[i].equals("-p")) {
					pro = args[++i];
				}
				if (args[i].equals("-seedBegin")) {
					begin = Integer.parseInt(args[++i]);
				}
				if (args[i].equals("-seedEnd")) {
					end = Integer.parseInt(args[++i]);
				}
				i++;
			}			
		}
		
		if (pro.length() > 0)
			config.Config.targetLib = pro;
		config.Config.seedBegin = begin;
		config.Config.seedEnd = end;
//		if (pro.equals("Ant") || pro.equals("ElasticSearch") || pro.equals("Lucene")) global.Parameters.VERSION = "";
	}
	
	private static void showHelp() {
		System.out.println("Using the default setting..");
	}
}
