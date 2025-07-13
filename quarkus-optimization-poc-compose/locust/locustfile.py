from locust import FastHttpUser, task, between, events
import time
import logging
import os

target_endpoint=os.environ.get('TARGET_ENDPOINT', '')
target_get_path=os.environ.get('TARGET_GET_PATH', '')

def silence_stats_logger():
    stats_printer_logger = logging.getLogger('locust.stats_logger')
    stats_printer_logger.setLevel(logging.CRITICAL + 1)
    stats_printer_logger.handlers.clear()

@events.test_start.add_listener
def on_test_start(environment, **kwargs):
    silence_stats_logger()
    initial_sleep_time = int(os.environ.get('INITIAL_SLEEP_TIME_SECONDS', 0))
    print("🕒 Waiting {} seconds before starting load test; strap-in, fuckos.".format(str(initial_sleep_time)))
    time.sleep(initial_sleep_time)
    print("...let's go! 🔥")
    print("starting test against {}{}".format(target_endpoint, target_get_path))

class StressTest(FastHttpUser):
    host = target_endpoint
    wait_time = between(1, 2)

    @task
    def hit_spring_be(self):
        self.client.get(target_get_path)