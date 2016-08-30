require "logger"

# Print to the screen.
logger = Logger.new(STDOUT)
logger.info "This is a info message."
logger.debug "This is a dibugging message."
logger.warn "This is a warning message."
logger.fatal "This is a fatal message."
logger.error "This is a error message."
logger.unknown "This is a unknown message."

# Print to a .txt file.
logger_txt = Logger.new("example_17.txt")
logger_txt.info "This is a info message."
logger_txt.debug "This is a dibugging message."
logger_txt.warn "This is a warning message."
logger_txt.fatal "This is a fatal message."
logger_txt.error "This is a error message."
logger_txt.unknown "This is a unknown message."
