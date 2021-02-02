package Theory.CatchRethrowChainSuppressed.Suppressed;


public class ExceptionExample1 {
        public static void test () throws Exception {
            Throwable throwable = null;
            Resource resource = new Resource();
            try {
                resource.use();
            } catch (Exception e) {
                throwable = e;
            } finally {
                try {
                    resource.close();
                } catch (Exception e) {
                    if (throwable != null) {
                        e.addSuppressed(throwable);
                        throw e;
                    }
                }
            }
        }

}

